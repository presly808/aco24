package week3.mvc.view;

import week3.mvc.controller.AdminController;
import week3.mvc.controller.LoginController;
import week3.mvc.controller.ServiceFactory;
import week3.mvc.model.human.User;
import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminView {
    private LoginController loginController;
    private AdminController adminController;
    private List<User> users;
    private List<Worker> workers;
    private List<Ticket> tickets;
    private String accessKey;

    public AdminView() {
        loginController = (LoginController) ServiceFactory.get("loginController");

    }


    public void login() {

        System.out.println("==================================");
        System.out.println("-You are trying to login as Admin-");
        System.out.println("==================================");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        accessKey = loginController.loginAsAdmin(username, password);
        if (accessKey != null) {
            adminController = (AdminController) ServiceFactory.get("adminController");
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
            login();
        }
        return adminController.hireWorker(worker);

    }

    public Worker fireWorker(Worker worker) throws Exception {
        if (accessKey == null) {
            login();
        }
        if (adminController.fireWorker(worker))
            return worker;
        throw new Exception("There is no such worker in database");

    }

    public void paySalary() {
        if (accessKey == null) {
            login();
        }
        adminController.paySalary();
    }

    public Map<String, Double> getSalaryInfoByWorkers() {
        if (accessKey == null) {
            login();
        }

        return adminController.getSalaryInfoByWorkers();
    }

    public int getWorkedHoursByWorker(Worker worker) {
        if (accessKey == null) {
            login();
        }
        return adminController.getWorkedHoursByWorker(worker);
    }


    public List<Worker> getInvolvedWorkers() {
        if (accessKey == null) {
            login();
        }
        return adminController.getInvolvedWorkers();
    }

    public List<Ticket> getclosedTickets() {
        if (accessKey == null) {
            login();
        }
        return adminController.getclosedTickets();
    }

    public List<Ticket> getOpenTickets() {
        if (accessKey == null) {
            login();
        }
        return adminController.getOpenTickets();
    }
}
