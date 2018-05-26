package week3.mvc.controller;

import com.google.gson.Gson;
import week3.mvc.dao.*;
import week3.mvc.db.*;
import week3.mvc.model.human.User;
import week3.mvc.model.human.Worker;
import week3.mvc.view.*;

import java.lang.reflect.Proxy;

public class ServiceFactory {

    //DATABASES
    static DBusers users;
    static DBworkers workers;
    static DBitems items;
    static DBtickets tickets;

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
    private static Dao<User> userDao;
    private static Dao<Worker> workerDao;
    private static TicketDao ticketDao;
    private static ItemDao itemDao;

    // additional
    private static Gson gson;

    public static Object getBean(String parameter) {
        switch (parameter) {
            case "users":
                return users == null ? users = new DBusers() : users;
            case  "workers":
                return  workers == null ? workers = new DBworkers() : workers;
            case "items":
                return  items == null ? items = new DBitems() : items;
            case "tickets":
                return tickets == null ? tickets = new DBtickets() : tickets;
            case "adminView":
                return proxyForAdmin();
            case "userView":
                return proxyForUser();
         //       return userViewImpl == null ? userViewImpl = new UserViewImpl() : userViewImpl;
            case "workerView":
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
            case "gson":
                return gson == null ? gson = new Gson() : gson;
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
