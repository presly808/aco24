package server;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {

        List<Token> tokens = new ArrayList<>();
        List<User> users = new ArrayList<>();
        Gson gson = new Gson();
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        try {
            server.createContext("/login", new HttpHandler() {
                @Override
                public void handle(HttpExchange exchange) throws IOException {
                    Scanner scanner = new Scanner(exchange.getRequestBody());
                    StringBuilder result = new StringBuilder();

                    if (exchange.getRequestMethod().equals("POST")) {
                        while (scanner.hasNextLine()) {
                            result.append(scanner.nextLine()).append("\n");
                        }

                        User user = gson.fromJson(String.valueOf(exchange.getRequestBody()), User.class);
                        System.out.println(user.toString());
                        users.add(user);

                        Token token = new Token();

                        try (OutputStream outputStream = exchange.getResponseBody()) {
                            String outPOST = gson.toJson(token);
                            exchange.sendResponseHeaders(200, outPOST.length());
                            System.out.println(exchange.getRequestURI());
                            outputStream.write(outPOST.getBytes());
                            tokens.add(token);
                            outputStream.flush();
                        }

                    } else if (exchange.getRequestMethod().equals("GET")) {
                        try (OutputStream outputStream = exchange.getResponseBody()) {
                            String outGET = "You have to send me login and pwd via POST method";
                            exchange.sendResponseHeaders(200, outGET.length());
                            outputStream.write(outGET.getBytes());
                        }
                    }
                }
            });
        } catch (Throwable tr) {
            tr.printStackTrace();
        }



        server.setExecutor(null);

        server.start();
        System.out.println("Server started");

    }
}
