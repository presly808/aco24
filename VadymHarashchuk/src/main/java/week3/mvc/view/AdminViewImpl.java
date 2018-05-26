package week3.mvc.view;


import com.google.gson.Gson;
import spark.Spark;
import week3.mvc.controller.AdminController;
import week3.mvc.controller.LoginController;
import week3.mvc.controller.ServiceFactory;
import week3.mvc.exceptions.LoginException;
import week3.mvc.model.human.User;
import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminViewImpl implements AdminView {
    private LoginController loginController;
    private AdminController adminController;
    private Gson gson;
    private String accessKey;

    public AdminViewImpl() {
        loginController = (LoginController) ServiceFactory.getBean("loginController");
        gson = (Gson) ServiceFactory.getBean("gson");
    }


    public void login() throws LoginException {

            Spark.post("/adminLogin", (req, resp) -> {
            String jsonBody = req.body();
                User user = gson.fromJson(jsonBody, User.class);
                accessKey = loginController.login(user.getName(), user.getPassword(), user.getType());

            HashMap<String, String> response = new HashMap<>();
            response.put("accessToken", accessKey);

            return gson.toJson(response);
        });

        System.out.println("==================================");
        System.out.println("-You are trying to login as Admin-");
        System.out.println("==================================");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        accessKey = loginController.login( username, password, "ADMIN");
        if (accessKey != null) {
            adminController = (AdminController) ServiceFactory.getBean("adminController");
            return;
        }
        try {
            throw new Exception("Credentials aren't correct");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean hireWorker(Worker worker) {
        if (accessKey == null) {
            //login();
        }
        return adminController.hireWorker(worker);

    }

    public Worker fireWorker(Worker worker) throws Exception {
        if (accessKey == null) {
            //login();
        }
        if (adminController.fireWorker(worker))
            return worker;
        throw new Exception("There is no such worker in database");

    }

    public void paySalary() {
        if (accessKey == null) {
            //login();
        }
        adminController.paySalary();
    }

    public Map<String, Double> getSalaryInfoByWorkers() {
        if (accessKey == null) {
            //login();
        }

        return adminController.getSalaryInfoByWorkers();
    }

    public int getWorkedHoursByWorker(Worker worker) {
        if (accessKey == null) {
            //login();
        }
        return adminController.getWorkedHoursByWorker(worker);
    }


    public List<Worker> getInvolvedWorkers() {
        if (accessKey == null) {
            //login();
        }
        return adminController.getInvolvedWorkers();
    }

    public List<Ticket> getclosedTickets() {
        if (accessKey == null) {
            //login();
        }
        return adminController.getclosedTickets();
    }

    public List<Ticket> getOpenTickets() {
        if (accessKey == null) {
            //login();
        }
        return adminController.getOpenTickets();
    }
}
