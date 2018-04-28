package week3.controller;

import week3.data.*;
import week3.model.*;

public class UserController {

    public static boolean giveItem(User user, Ticket ticket) {
        if (user == null || ticket == null) {
            return false;
        }
        UserDao.createUser(user);
        TicketDao.createTicket(ticket);
        return true;
    }

    public static boolean checkTicketStatus(User user) {
        if (user == null) {
            return false;
        }
        for (int i = 0; i < UserDao.readUsers().size(); i++) {
            if (UserDao.readUsers().get(i).equals(user) ) {
                return TicketDao.readTickets().get(i).isStatus();
            }
        }
        return false;
    }

    public static boolean takeItemBack(User user) {
        if (user == null) {
            return false;
        }
        UserDao.deleteUser(user);
        return true;
    }

    public static String leaveComment(User user, String notes) {
        if (user == null || notes.equals("")){
            return "EMPTY";
        }
        for (int i = 0; i < UserDao.readUsers().size(); i++) {
            if (UserDao.readUsers().get(i).equals(user)) {
                TicketDao.readTickets().get(i).setNotes(notes);
                return TicketDao.readTickets().get(i).getNotes();
            }
        }
        return "EMPTY";
    }

    public static boolean changeUserInfo(User user, User newUser) {
        if (user == null || newUser == null) return false;
        UserDao.updateUser(user,newUser);
        return true;
    }

    public static boolean changeTicketInfo(User user, Ticket newTicket) {
        if (user == null || newTicket == null) return false;
        for (int i = 0; i < UserDao.readUsers().size(); i++) {
            if (UserDao.readUsers().get(i).equals(user)) {
                TicketDao.updateTicket(DataBase.tickets.get(i),newTicket);
            }
        }
        return true;
    }

    public static String toSeeUserInfo(User user) {
        if (user == null) return null;
        for (int i = 0; i < UserDao.readUsers().size(); i++) {
            if (UserDao.readUsers().get(i).equals(user)) {
                return UserDao.readUsers().get(i).toString();
            }
        }
        return null;
    }

    public static String toSeeTicketInfo(User user) {
        if (user == null) return null;
        for (int i = 0; i < UserDao.readUsers().size(); i++) {
            if (UserDao.readUsers().get(i).equals(user)) {
                return TicketDao.readTickets().get(i).toString();
            }
        }
        return null;
    }
}
