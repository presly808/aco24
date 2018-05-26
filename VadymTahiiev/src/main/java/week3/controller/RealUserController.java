package week3.controller;

import week3.data.*;
import week3.model.*;

public class RealUserController implements UserController {

    private static int id_next = 1;
    private int id = 0;


    @Override
    public boolean createUserAccount(String name, String phoneNumber, int password) {
        id = id_next++;
        User user = new User();
        Ticket ticket = new Ticket();
        Password pass = new Password();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setId(id);
        UserDao.createUser(user);
        ticket.setId(id);
        TicketDao.createTicket(ticket);
        pass.setId(id);
        pass.setPassword(password);
        return UserLogDao.createPassword(pass);
    }

    @Override
    public Ticket giveItem(String productName, String productModel,
                           double productPrice, String notes, int id, int password) {
        Ticket ticket = new Ticket();

        ticket.setProductName(productName);
        ticket.setProductModel(productModel);
        ticket.setProductPrice(productPrice);
        ticket.setRepairingPrice(productPrice * 0.1);
        ticket.setNotes(notes);
        ticket.setStatus(false);
        ticket.setId(id);

        return TicketDao.createTicket(ticket);
    }

    @Override
    public boolean checkTicketStatus(int id, int password) {
        if (TicketDao.readTicket(id).isStatus() == true) {
            System.out.println("Item is repaired");
            return true;
        } else {
            System.out.println("Item is not repaired");
            return false;
        }
    }

    @Override
    public Ticket takeItemBack(int id, int password) {
        for (int i = 0; i < DataBase.passwords.size(); i++) {
            if (DataBase.passwords.get(i).getId() == id) {
                UserLogDao.deletePassword(DataBase.passwords.get(i));
                UserDao.deleteUser(UserDao.readUser(id));
            }
        }
        return TicketDao.deleteTicket(TicketDao.readTicket(id));
    }

    @Override
    public String leaveComment(int id, int password, String comment) {
        Ticket updatedTicket = TicketDao.readTicket(id);
        updatedTicket.setNotes(comment);
        return TicketDao.updateTicket(updatedTicket);
    }
}
