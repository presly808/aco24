package week8.servicecentre.server;

import com.google.gson.Gson;
import week2.mvc.exception.MyLoginException;
import week8.servicecentre.controller.*;
import week8.servicecentre.model.User;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class MyServer {
    public static void main(String[] args) {
        Gson gson = new Gson();
        IUserController userController = new ProxyUserController();
        port(8000);

        get("/main", ((request, response) -> "Service centre"));

        post("/register", (request, response) -> {
            String jsonBody = request.body();
            User user = gson.fromJson(jsonBody, User.class);
            try {
                userController.registerUser(user.getName(), user.getPhoneNumber(), user.getPassword());
                return "register successful";
            } catch (MyLoginException e) {
                e.printStackTrace();
                return gson.toJson(e);
            }

        });

        post("/login", (req, resp) -> {
            String jsonBody = req.body();
            User user = gson.fromJson(jsonBody, User.class);
            try {
                userController.loginUser(user.getName(), user.getPassword());
                return "login successful";
            } catch (MyLoginException e) {
                e.printStackTrace();
                return gson.toJson(e);
            }
        });

    }
}
