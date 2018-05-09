package week3.mvc.controller;

import week3.mvc.db.DataBase;
import week3.mvc.model.human.Worker;
import week3.mvc.view.AdminView;
import week3.mvc.view.UserView;
import week3.mvc.view.WorkerViewImpl;

public class ServiceCenterControllerImpl {

    //database
    public DataBase dataBase;

    //controllers
    private AdminController adminController;
    private UserController userController;
    private WorkerController workerController;


    //views
    AdminView adminViewImpl;
    WorkerViewImpl workerViewImpl;
    UserView userViewImpl;

    public ServiceCenterControllerImpl(){

        dataBase = (DataBase) ServiceFactory.get("database");

        adminController = (AdminController) ServiceFactory.get("adminController");
        userController = (UserController) ServiceFactory.get("userController");
        workerController = (WorkerController) ServiceFactory.get("workerController");

        adminViewImpl = (AdminView) ServiceFactory.get("adminViewImpl");
        workerViewImpl = (WorkerViewImpl) ServiceFactory.get("workerViewImpl");
        userViewImpl = (UserView) ServiceFactory.get("userViewImpl");
    }

    public static void main(String[] args) {

        ServiceCenterControllerImpl serviceCenter = new ServiceCenterControllerImpl();

        //create workers in database
        Worker worker1 = new Worker("Petro", "+380123456789", 8500);
        Worker worker2 = new Worker("Volodymyr", "+380123456789", 8000);
        Worker worker3 = new Worker("Vasyl", "+380123456789", 8000);

        //hire workers - add to database
        serviceCenter.adminViewImpl.login();
        serviceCenter.adminViewImpl.hireWorker(worker1);
        serviceCenter.adminViewImpl.hireWorker(worker2);
        serviceCenter.adminViewImpl.hireWorker(worker3);

        serviceCenter.userViewImpl.login();
        serviceCenter.userViewImpl.leaveComment("Hello");




    }




}
