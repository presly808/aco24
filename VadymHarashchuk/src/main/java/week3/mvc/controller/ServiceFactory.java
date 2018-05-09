package week3.mvc.controller;

import week3.mvc.dao.*;
import week3.mvc.db.DataBase;
import week3.mvc.view.*;

import java.lang.reflect.Proxy;

public class ServiceFactory {

    static DataBase database;

    //VIEWS
    private static AdminView adminViewImpl;
    private static UserViewImpl userViewImpl;
    private static WorkerViewImpl workerViewImpl;

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
            case "adminViewImpl":
                return proxyForAdmin();
            case "userViewImpl":
                return proxyForUser();
         //       return userViewImpl == null ? userViewImpl = new UserViewImpl() : userViewImpl;
            case "workerViewImpl":
                return workerViewImpl == null ? workerViewImpl = new WorkerViewImpl() : workerViewImpl;
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

        if(adminViewImpl == null)
        adminViewImpl = new AdminViewImpl();

        ClassLoader classLoader = adminViewImpl.getClass().getClassLoader();
        Class<?>[] interfaces = adminViewImpl.getClass().getInterfaces();
        LogActionsProxy invocationHandler = new LogActionsProxy(adminViewImpl);

        AdminView proxyAdmin = (AdminView) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        return proxyAdmin;
    }

    public static UserView proxyForUser(){

        if(userViewImpl == null)
            userViewImpl = new UserViewImpl();

        ClassLoader classLoader = userViewImpl.getClass().getClassLoader();
        Class<?>[] interfaces = userViewImpl.getClass().getInterfaces();
        LogActionsProxy invocationHandler = new LogActionsProxy(userViewImpl);

        UserView proxyUser = (UserView) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        return proxyUser;
    }


}
