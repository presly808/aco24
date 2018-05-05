package week3.mvc.controller;

import week3.mvc.db.DataBase;
import week3.mvc.model.human.Worker;
import week3.mvc.view.AdminView;
import week3.mvc.view.UserView;
import week3.mvc.view.WorkerView;

public class ServiceCenterControllerImpl {

    //database
    DataBase dataBase;

    //controllers
    private AdminController adminController;
    private UserController userController;
    private WorkerController workerController;


    //views
    AdminView adminView;
    WorkerView workerView;
    UserView userView;

    public ServiceCenterControllerImpl(){

        dataBase = (DataBase) ServiceFactory.get("database");

        adminController = (AdminController) ServiceFactory.get("adminController");
        userController = (UserController) ServiceFactory.get("userController");
        workerController = (WorkerController) ServiceFactory.get("workerController");

        adminView = (AdminView) ServiceFactory.get("adminView");
        workerView = (WorkerView) ServiceFactory.get("workerView");
        userView = (UserView) ServiceFactory.get("userView");
    }

    public static void main(String[] args) {

        ServiceCenterControllerImpl serviceCenter = new ServiceCenterControllerImpl();

        //create workers in database
        Worker worker1 = new Worker("Petro", "+380123456789", 8500);
        Worker worker2 = new Worker("Volodymyr", "+380123456789", 8000);
        Worker worker3 = new Worker("Vasyl", "+380123456789", 8000);

        //hire workers - add to database
        serviceCenter.adminView.hireWorker(worker1);
        serviceCenter.adminView.hireWorker(worker2);
        serviceCenter.adminView.hireWorker(worker3);




    }




}
