package week6.httpserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class httpserver {

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
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
//                System.out.println("Hello method has been invoked");
//                String ss = "response";
//                httpExchange.sendResponseHeaders(200,ss.length());
                if (httpExchange.getRequestMethod().equals("POST")){
                    Scanner scanner = new Scanner(httpExchange.getRequestBody());
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    line = scanner.nextLine();
                    System.out.println(line);
                }
            }
        });

        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("server started");
    }
}
