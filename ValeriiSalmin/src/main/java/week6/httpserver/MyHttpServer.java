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
import java.util.HashMap;
import java.util.Map;

public class MyHttpServer {

    static Map<String, User> accessKeyMap = new HashMap<String,User>();

    Map<String, User> userMap = ObjectHolder.createUserMap();

    public boolean isLoggedIn(String accessToken) {
        return accessKeyMap.containsKey(accessToken);
    }

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        Map<String, User> userMap = ObjectHolder.createUserMap();

        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

        httpServer.createContext("/login", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                if (httpExchange.getRequestMethod().equals("POST")) {
                    final String[] accessKey = {null};

                    User user = gson.fromJson(ObjectHolder.getDataFromServer(httpExchange), User.class);

                    accessKey[0] = user.login(user);

                    Map<Object, Object> response = new HashMap<>();
                    response.put("accessToken", accessKey[0]);
                    accessKeyMap.put(accessKey[0],user);
                    String tt = gson.toJson(response);

                    try (OutputStream outputStream = httpExchange.getResponseBody()) {
                        httpExchange.sendResponseHeaders(200, tt.length());
                        outputStream.write(tt.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    }
                }
            }
        });


        httpServer.createContext("/post/new", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                if (httpExchange.getRequestHeaders().containsKey("accessToken")) {
                    accessKeyMap.forEach((k, v) -> {
                        if (k.equals(httpExchange.getRequestHeaders().getFirst("accessToken"))) {
                            Post post = gson.fromJson(ObjectHolder.getDataFromServer(httpExchange), Post.class);

                            Map<Object, Object> response = new HashMap<>();
                            response.put("id", post.getId());
                            response.put("title", post.getTitle());
                            response.put("body", post.getBody() );
                            String tt = gson.toJson(response);

                            try (OutputStream outputStream = httpExchange.getResponseBody()) {
                                httpExchange.sendResponseHeaders(200, tt.length());
                                outputStream.write(tt.getBytes());
                                outputStream.flush();
                                outputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("you aren't logged in");
                        }
                    });
                } else {
                    System.out.println("There is no access key");
                }
            }
        });

        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("server started");
    }
}
