package week2.mvc.server;

import com.google.gson.Gson;
import week2.mvc.controller.ContactController;
import week2.mvc.controller.ContactControllerImpl;
import week2.mvc.model.DataModelImpl;
import week2.mvc.model.User;

import static spark.Spark.*;

public class MyServer {

    public static void main(String[] args) {

        ContactController controller = (ContactController) ObjectHolder.getBean("contactController");
        Gson gson = (Gson) ObjectHolder.getBean("gson");


        port(8080);
        get("/contact/all", (request, response) -> (gson.toJson(controller.getAll())));
        get("/hello", ((request, response) -> "Hello"));
        get("/login", ((request, response) -> {
            String jsonBody = request.body();
            User user = gson.fromJson(jsonBody, User.class);
            return user.getId();
        }));
    }


}
