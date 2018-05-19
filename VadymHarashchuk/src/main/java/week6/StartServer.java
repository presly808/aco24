package week6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.stream.Collectors;

public class StartServer {
    private HttpServer server;
    private List<User> users;
    private Map<User, String> creds;


    public StartServer() {
        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
            users = new ArrayList<>();
            creds = new HashMap<>();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        StartServer startServer = new StartServer();
        startServer.start();

    }

    public void start() {
        users.addAll(Arrays.asList(new User("Elvis Presley", "presly", "12345"),
                new User("Vad Vadym", "vadoskin", "password123"),
                new User("Mykola Mykolenko", "kolyan2014", "12345"),
                new User("Vasya Maximov", "vasya27", "12345"),
                new User("Max Makar", "maxxis", "55555")));

        users.get(0).addPosts(Arrays.asList(new Post("WTF", "test post")
                , new Post("#2", "test post2")));

        server.createContext("/login", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                String accessKey;
                OutputStream stream = httpExchange.getResponseBody();

                User parsedUser = new Gson().fromJson(jsonFromRequest(httpExchange), User.class);
                User goalUser = users.stream()
                        .filter(user -> user.getUser().equals(parsedUser.getUser())
                                && user.getPass().equals(parsedUser.getPass()))
                        .findFirst().orElse(null);

                if (goalUser != null) {
                    accessKey = Base64.getEncoder()
                            .encodeToString((goalUser.getUser() + goalUser.getPass()).getBytes());
                    creds.put(goalUser, accessKey);
                    Map<String, String> map = new HashMap<>();
                    map.put("accessKey", accessKey);
                    sendResponse(httpExchange, stream, map);
                } else {
                    byte[] error = "There is no such registerd user!".getBytes();
                    httpExchange.sendResponseHeaders(400, error.length);
                    stream.write(error);
                    stream.close();
                }
            }
        });

        server.createContext("/username/", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                OutputStream stream = httpExchange.getResponseBody();
                User userString = validateAccessKeyWithQuery(httpExchange);

                if (userString != null) {
                    sendResponse(httpExchange, stream, userString);
                }
                else {
                    byte[] error = "There is no such registered user!".getBytes();
                    httpExchange.sendResponseHeaders(400, error.length);
                    stream.write(error);
                    stream.close();
                }
            }
        });

        server.createContext("/post/new", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                OutputStream stream = httpExchange.getResponseBody();
                User authUser = validateAccessKey(httpExchange);

                if (authUser != null) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(jsonFromRequest(httpExchange));
                    Post post = new Gson().fromJson(builder.toString(), Post.class);
                    post.setId();
                    authUser.addPost(post);
                    sendResponse(httpExchange, stream, post);
                }
            }
        });

        server.createContext("/user/find", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                OutputStream stream = httpExchange.getResponseBody();
                User authUser = validateAccessKey(httpExchange);

                if (authUser != null) {
                    String key = httpExchange.getRequestURI()
                            .getQuery().split("=")[1];

                    List<User> u = users.stream()
                            .filter(user -> user.getName().contains(key))
                            .collect(Collectors.toList());
                    List<Map<String, String>> list = u.stream()
                            .map(user -> new HashMap<String, String>() {{
                                put("name", user.getName());
                                put("url", "/user/" + user.getUser());
                            }}).collect(Collectors.toList());
                    sendResponse(httpExchange, stream, list.toString());
                }
            }
        });


        server.createContext("/posts/", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                OutputStream stream = httpExchange.getResponseBody();
                User authUser = validateAccessKey(httpExchange);
                int id = Integer.parseInt(httpExchange.getRequestURI().getQuery());

                if (authUser != null) {
                    Post post = authUser.getPosts().stream()
                            .filter(p -> p.getId() == id)
                            .findFirst()
                            .orElse(null);
                    if (post == null) {
                        byte[] error = "There is no post with such id".getBytes();
                        httpExchange.sendResponseHeaders(400, error.length);
                        stream.write(error);
                        stream.close();
                        return;
                    }
                    sendResponse(httpExchange, stream, post);
                }
            }
        });
        server.setExecutor(null);
        server.start();
    }

    private static void sendResponse(HttpExchange httpExchange, OutputStream stream, Object object) {
        byte[] json = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .disableHtmlEscaping()
                .create()
                .toJson(object).getBytes();
        try {
            httpExchange.sendResponseHeaders(200, json.length);
            stream.write(json);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String jsonFromRequest(HttpExchange httpExchange) {
        Scanner scanner = new Scanner(httpExchange.getRequestBody());
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine());

        }
        return builder.toString();
    }

    private User validateAccessKeyWithQuery(HttpExchange httpExchange) {
        OutputStream stream = null;

        for (String key : creds.values()) {
            if (httpExchange.getRequestHeaders()
                    .getFirst("accessKey")
                    .equals(key)) {
                String username = httpExchange.getRequestURI()
                        .getQuery();
                return users.stream()
                        .filter(user -> user.getUser().equals(username))
                        .findFirst()
                        .orElse(null);
            } else {
                byte[] error = "Access key is not valid!".getBytes();
                try {
                    httpExchange.sendResponseHeaders(401, error.length);
                    stream.write(error);
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private User validateAccessKey(HttpExchange httpExchange) {
        OutputStream stream = null;

        for (Map.Entry<User, String> pair : creds.entrySet()) {
            if (httpExchange.getRequestHeaders()
                    .getFirst("accessKey")
                    .equals(pair.getValue())) {
                return pair.getKey();
            } else {
                byte[] error = "Access key is not valid!".getBytes();
                try {
                    httpExchange.sendResponseHeaders(401, error.length);
                    stream.write(error);
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}