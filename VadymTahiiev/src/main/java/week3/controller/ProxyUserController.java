package week3.controller;

import week3.data.DataBase;
import week3.data.UserLogDao;
import week3.model.*;

public class ProxyUserController implements UserController {
    private RealUserController realUserController;

    public ProxyUserController() {
        realUserController = new RealUserController();
    }

    @Override
    public boolean createUserAccount(String name, String phoneNumber, int password) {
        if (name.isEmpty() || phoneNumber.isEmpty()) {
            System.out.println("Invalid name or phone number");
            return false;
        }
        return realUserController.createUserAccount(name, phoneNumber, password);
    }

    @Override
    public Ticket giveItem(String productName, String productModel,
                           double productPrice, String notes, int id, int password) {
        if (password != UserLogDao.readPassword(id)) {
            System.out.println("Invalid ID or password");
            return null;
        }

        if (productName == null || productModel == null || productPrice <= 0) {
            System.out.println("Invalid ticket");
            return null;
        }

        return realUserController.giveItem(productName, productModel, productPrice,
                notes, id, password);
    }

    @Override
    public boolean checkTicketStatus(int id, int password) {
        for (int i = 0; i < DataBase.tickets.size(); i++) {
            if (DataBase.tickets.get(i).getId() == id || password == UserLogDao.readPassword(id)) {
                    return realUserController.checkTicketStatus(id, password);
            }  else {
                System.out.println("Invalid ID or password");
                return false;
            }
        }
        return false;
    }

    @Override
    public Ticket takeItemBack(int id, int password) {
        for (int i = 0; i < DataBase.tickets.size(); i++) {
            if (DataBase.tickets.get(i).getId() == id || password == UserLogDao.readPassword(id)) {
                return realUserController.takeItemBack(id, password);
            }  else {
                System.out.println("Invalid ID or password");
                return null;
            }
        }
        return null;
    }

    @Override
    public String leaveComment(int id, int password, String comment) {
        for (int i = 0; i < DataBase.tickets.size(); i++) {
            if (DataBase.tickets.get(i).getId() == id || password == UserLogDao.readPassword(id)) {
                return realUserController.leaveComment(id, password,  comment);
            }  else {
                System.out.println("Invalid ID or password");
                return null;
            }
        }
        return null;
    }
}
