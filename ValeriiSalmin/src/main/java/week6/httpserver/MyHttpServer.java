package week6.httpserver;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import week6.utils.ObjectHolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Scanner;

public class MyHttpServer {



    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        Map<String, User> userMap = ObjectHolder.createUserMap();

        HttpServer httpServer = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8080), 0);

        httpServer.createContext("/test", new HttpHandler() {

            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                String url = httpExchange.getRequestURI().toString();
                System.out.println(httpExchange.getProtocol());
                System.out.println(httpExchange.getRequestMethod());

                System.out.println(url);

                String[] params = url.split("\\?")[1].split("&");
                String name = params[0].split("=")[1];

                try (OutputStream outputStream = httpExchange.getResponseBody()) {
                    String ss = "response from "+name;
                    httpExchange.sendResponseHeaders(200,ss.length());
                    outputStream.write(ss.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }
            }
        });

        httpServer.createContext("/postInfo", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                if (httpExchange.getRequestMethod().equals("POST")){
                    Scanner scanner = new Scanner(httpExchange.getRequestBody());
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    line = scanner.nextLine();
                    System.out.println(line);
                }
            }
        });

        httpServer.createContext("/login", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                if (httpExchange.getRequestMethod().equals("POST")){
                    final String[] accessKey = {null};
                    BufferedReader br = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody()));
                    StringBuilder sb = new StringBuilder();
                    while (br.ready()){
                        sb.append(br.readLine());
                                //.append("\n");
                    }
                    br.close();
                    String jsonBody = gson.toJson(sb);
                    User user = gson.fromJson(jsonBody, User.class);

                    userMap.forEach((k,v)->{
                        if (user.getName().equals(v.getName()) && (user.getPassword().equals(v.getPassword()))){
                            accessKey[0] = user.getAccessKey(user.getName(),user.getPassword());
                            System.out.println(accessKey[0]);
                        }
                    });

                    try (OutputStream outputStream = httpExchange.getResponseBody()) {
                        String ss = "response";
                        httpExchange.sendResponseHeaders(200,ss.length());
                        outputStream.write(ss.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    }
                }
            }
        });

        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("server started");
    }
}
