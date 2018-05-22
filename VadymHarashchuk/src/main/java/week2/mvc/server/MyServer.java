package week2.mvc.server;

import com.google.gson.Gson;
import week2.mvc.controller.ContactController;
import week2.mvc.controller.UserController;
import week2.mvc.exception.MyLoginException;
import week2.mvc.exception.RegisterException;
import week2.mvc.model.User;
import week2.mvc.utils.ObjectHolder;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class MyServer {


    public static void main(String[] args) {

        String port = args.length != 0 ? args[0] : "8080";

        Gson gson = ObjectHolder.getBean("gson");
        ContactController contactController =
                ObjectHolder.getBean("contactController");
        UserController userController =
                ObjectHolder.getBean("userController");

        port(Integer.parseInt(port));


//        String classPathStaticFiles = MyServer.class.getResource("/exclude/week2/mvc/view/").getFile();
        String classPathStaticFiles = "/home/vadim/Documents/course/aco24/VadymHarashchuk/src/main/java/week2/mvc/view/";
        externalStaticFileLocation(classPathStaticFiles);

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));


        get("/hello", ((request, response) -> "Hello"));

        get("/contact/all", (request, response) -> {
            String accessToken = request.headers("accessToken");
            boolean hasSession = userController.isLoggedIn(accessToken);

            if(hasSession){
                return gson.toJson(contactController.getAll());
            } else {
                return gson.toJson(new MyLoginException("No session found"));
            }

        });

        post("/login", (req, resp) -> {
            String jsonBody = req.body();
            User user = gson.fromJson(jsonBody, User.class);
            try {
                String accessKey = userController.login(user.getName(), user.getPass());
                Map<Object, Object> response = new HashMap<>();
                response.put("accessToken", accessKey);
                return gson.toJson(response);
            } catch (MyLoginException e) {
                e.printStackTrace();
                return gson.toJson(e);
            }
        });

        post("/register", (req, resp) -> {
            String jsonBody = req.body();
            User user = gson.fromJson(jsonBody, User.class);
            try {
                User created = userController.register(user.getName(), user.getPass());
                return gson.toJson(created);
            } catch (RegisterException e) {
                return gson.toJson(e);
            }
        });
    }

}
