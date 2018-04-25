package week3.servicecenter.utils;

import week3.servicecenter.controller.*;
import week3.servicecenter.dao.*;
import week3.servicecenter.model.DB;

public class ObjectFactory {

    private static DB db;

    private static AdminController adminController;
    private static WorkerController workerController;
    private static UserController userController;

    private static ItemDao itemDao;
    private static TicketDao ticketDao;
    private static UserDao userDao;
    private static WorkerDao workerDao;

    public static Object get(String string){

        if (string == null){
            return null;
        }

        if (string.equals("DB")){
            if (db == null) {
                return new DB();
            } else return db;
        }

        if (string.equals("AdminController")) {
            if (adminController == null) {
                return new AdminControllerImpl();
            } else return adminController;
        }

        if (string.equals("UserController")) {
            if (userController == null) {
                return new UserControllerImpl();
            } else return userController;
        }

        if (string.equals("WorkerController")) {
            if (workerController == null) {
                return new WorkerControllerImpl();
            } else return workerController;
        }

        if (string.equals("ItemDao")) {
            if (itemDao == null) {
                return new ItemDaoImpl();
            } else return itemDao;
        }
        if (string.equals("TicketDao")) {
            if (ticketDao == null) {
                return new TicketDaoImpl();
            } else return ticketDao;
        }
        if (string.equals("UserDao")) {
            if (userDao == null) {
                return new UserDaoImpl();
            } else return userDao;
        }
        if (string.equals("WorkerDao")) {
            if (workerDao == null) {
                return new WorkerDaoImpl();
            } else return workerDao;
        }
        return null;
    }
}
