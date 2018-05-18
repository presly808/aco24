package week6.httpserver;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import week6.utils.Helper;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class MyHttpServer {

    static Map<String, User> accessKeyMap = new HashMap<String,User>();

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        Helper.createUserMap();

        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8080), 0);

        httpServer.createContext("/login", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                if (httpExchange.getRequestMethod().equals("POST")) {
                    final String[] accessKey = {null};

                    User user = gson.fromJson(Helper.getDataFromServer(httpExchange), User.class);

                    accessKey[0] = user.login(user);

                    Map<Object, Object> response = new HashMap<>();
                    response.put("accessToken", accessKey[0]);
                    accessKeyMap.put(accessKey[0],user);

                    Helper.writeResponse(httpExchange, gson.toJson(response));
                }
            }
        });

        httpServer.createContext("/post/new", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                if (httpExchange.getRequestMethod().equals("POST")) {
                    if (httpExchange.getRequestHeaders().containsKey("accessToken")) {
                        accessKeyMap.forEach((k, v) -> {
                            if (k.equals(httpExchange.getRequestHeaders().getFirst("accessToken"))) {
                                Post post = gson.fromJson(Helper.getDataFromServer(httpExchange), Post.class);

                                v.addPost(post);

                                Map<Object, Object> response = new HashMap<>();
                                response.put("id", post.getId());
                                response.put("title", post.getTitle());
                                response.put("body", post.getBody());

                                Helper.writeResponse(httpExchange, gson.toJson(response));

                            } else {
                                System.out.println("you aren't logged in");
                            }
                        });
                    } else {
                        System.out.println("There is no access key");
                    }
                }else {
                    String requestURL = httpExchange.getRequestURI().toString();
                    int postId = Integer.parseInt(requestURL.substring(requestURL.indexOf("/post/")+6));
                    System.out.println(postId);
                    if (httpExchange.getRequestHeaders().containsKey("accessToken")) {
                        accessKeyMap.forEach((k, v) -> {
                             Post post = v.getPostsLists().stream()
                                    .filter(p -> p.getId() == postId)
                                    .findFirst().get();

                            Map<Object, Object> response = new HashMap<>();
                            response.put("id", post.getId());
                            response.put("title", post.getTitle());
                            response.put("body", post.getBody());

                            Helper.writeResponse(httpExchange, gson.toJson(response));
                        });

                    }
                }
            }
        });

        httpServer.setExecutor(null);
        httpServer.start();
        System.out.println("server started");
    }
}
