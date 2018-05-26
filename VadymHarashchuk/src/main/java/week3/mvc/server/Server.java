package week3.mvc.server;

import com.google.gson.Gson;
import java.util.HashMap;
import spark.Spark;
import week3.mvc.controller.LoginController;
import week3.mvc.controller.ServiceFactory;
import week3.mvc.dao.Dao;
import week3.mvc.dao.UserDaoImpl;
import week3.mvc.model.human.User;
import week3.mvc.model.human.Worker;

public class Server {

    public Server() {
    }

    public static void main(String[] args) {
        String port = args.length != 0 ? args[0] : "8080";
        Gson gson = (Gson) ServiceFactory.getBean("gson");
       // ServiceCenterControllerImpl serviceCenter = new ServiceCenterControllerImpl();


        LoginController loginController = (LoginController) ServiceFactory.getBean("loginController");

        Spark.port(Integer.parseInt(port));
        String classPathStaticFiles = "/home/vadim/Documents/course/aco24/VadymHarashchuk/src/main/java/week3/mvc/view/";

        Spark.externalStaticFileLocation(classPathStaticFiles);
        Spark.before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
        });

        Spark.get("/user", (request, response) -> new Gson().toJson(
                loginController.getUser(loginController.isLoggedIn(request.headers("accessToken")))));

//        Spark.get("/contact/all", (request, response) -> {
//            String accessToken = request.headers("accessToken");
//            boolean hasSession = loginController.isLoggedIn(accessToken);
//            return hasSession ? gson.toJson(contactController.getAll()) : gson.toJson(new LoginException("No session found"));
//        });

        Spark.post("/login", (req, resp) -> {
            String jsonBody = req.body();
            String accessKey = "";
            if (jsonBody.contains("USER")) {
                User user = gson.fromJson(jsonBody, User.class);
                accessKey = loginController.login(user.getName(), user.getPassword(), user.getType());
            } else {
                Worker worker = gson.fromJson(jsonBody, Worker.class);
                accessKey = loginController.login(worker.getName(), worker.getPassword(), worker.getType());
            }
            HashMap<String, String> response = new HashMap<>();
            response.put("accessToken", accessKey);

            return gson.toJson(response);
        });


        Spark.post("/register", (req, resp) -> {
            String jsonBody = req.body();
            if (jsonBody.contains("USER")) {
                User user = gson.fromJson(jsonBody, User.class);
                Dao<User> users = (UserDaoImpl) ServiceFactory.getBean("userDao");
               return users.create(user);

            }
            return null;
        });
    }
}
