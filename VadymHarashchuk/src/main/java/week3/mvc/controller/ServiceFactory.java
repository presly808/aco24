package week3.mvc.controller;

import week3.mvc.dao.*;
import week3.mvc.db.DataBase;
import week3.mvc.view.AdminView;
import week3.mvc.view.UserView;
import week3.mvc.view.WorkerView;

import java.lang.reflect.Proxy;

public class ServiceFactory {

    static DataBase database;

    //VIEWS
    private static AdminView adminView;
    private static UserView userView;
    private static WorkerView workerView;

    //CONTROLLERS
    private static AdminController adminController;
    private static WorkerController workerController;
    private static UserController userController;
    private static LoginController loginController;

    //DAO

    private static UserDao userDao;
    private static WorkerDao workerDao;
    private static TicketDao ticketDao;
    private static ItemDao itemDao;

    public static Object get(String parameter) {
        switch (parameter) {
            case "database":
                return database == null ? database = new DataBase() : database;
            case "adminView":
                return proxyForAdmin();
            case "userView":
                return userView == null ? userView = new UserView() : userView;
            case "workerView":
                return workerView == null ? workerView = new WorkerView() : workerView;
            case "adminController":
                return adminController == null ? adminController = new AdminControllerImpl() : adminController;
            case "userController":
                return userController == null ? userController = new UserControllerImpl() : userController;
            case "workerController":
                return workerController == null ? workerController = new WorkerControllerImpl() : workerController;
            case "loginController":
                return loginController == null ? loginController = new LoginControllerImpl() : loginController;
                case "userDao":
                return  userDao == null ? userDao = new UserDaoImpl() : userDao;
            case "workerDao":
                return workerDao == null ? workerDao = new WorkerDaoImpl() : workerDao;
            case "ticketDao":
                return ticketDao == null ? ticketDao = new TicketDaoImpl() : ticketDao;
            case "itemDao":
                return itemDao == null ? itemDao = new ItemDaoImpl() : itemDao;
            default:
                return null;
        }

    }

    public static AdminView proxyForAdmin(){

        if(adminView == null)
        adminView = new AdminView();

        ClassLoader classLoader = adminView.getClass().getClassLoader();
        Class<?>[] interfaces = adminView.getClass().getInterfaces();
        LogActionsProxy invocationHandler = new LogActionsProxy(adminView);

        AdminView proxyAdmin = (AdminView) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        return proxyAdmin;

    }


}
