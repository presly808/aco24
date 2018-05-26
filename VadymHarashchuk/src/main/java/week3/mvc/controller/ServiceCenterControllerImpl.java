package week3.mvc.controller;

import com.google.gson.Gson;
import week3.mvc.db.*;
import week3.mvc.model.human.User;
import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;
import week3.mvc.view.AdminView;
import week3.mvc.view.UserView;
import week3.mvc.view.WorkerViewImpl;

public class ServiceCenterControllerImpl {

    //database
    private DBusers users;
    private DBworkers dBworkers;
    private DBitems items;
    private DBtickets tickets;

    //controllers
    public AdminController adminController;
    public UserController userController;
    public WorkerController workerController;


    //views
    AdminView adminViewImpl;
    WorkerViewImpl workerViewImpl;
    UserView userViewImpl;

    public ServiceCenterControllerImpl(){

        users = (DBusers) ServiceFactory.getBean("users");

        adminController = (AdminController) ServiceFactory.getBean("adminController");
        userController = (UserController) ServiceFactory.getBean("userController");
        workerController = (WorkerController) ServiceFactory.getBean("workerController");

        adminViewImpl = (AdminView) ServiceFactory.getBean("adminView");
        workerViewImpl = (WorkerViewImpl) ServiceFactory.getBean("workerView");
        userViewImpl = (UserView) ServiceFactory.getBean("userView");
    }

    public static void main(String[] args) {

        ServiceCenterControllerImpl serviceCenter = new ServiceCenterControllerImpl();

        //create workers in database
        Worker worker1 = new Worker("Petro", "+380123456789", 8500);
        Worker worker2 = new Worker("Volodymyr", "+380123456789", 8000);
        Worker worker3 = new Worker("Vasyl", "+380123456789", 8000);

        //hire workers - add to database
//        serviceCenter.adminViewImpl.login();
//        serviceCenter.adminViewImpl.hireWorker(worker1);
//        serviceCenter.adminViewImpl.hireWorker(worker2);
//        serviceCenter.adminViewImpl.hireWorker(worker3);

      //  serviceCenter.userViewImpl.login();
        serviceCenter.adminController.createUser(new User
                ("Tester", "+38093"
                ,new Ticket(new Item("Honda", "moto", "FIXED"), 4)));

        serviceCenter.adminController.findUsers("Honda").stream()
        .map(user -> new Gson().toJson(user)).forEach(System.out::println);




    }




}
