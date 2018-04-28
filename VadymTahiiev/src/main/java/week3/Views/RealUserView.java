package week3.Views;

import week3.controller.*;
import week3.data.*;
import week3.model.*;

import java.util.Scanner;


public class RealUserView implements UserView {
    private Scanner sc;
    private User user;
    private Ticket ticket;

    @Override
    public boolean createUser() {
        sc = new Scanner(System.in);
        user = new User();
        ticket = new Ticket();

        System.out.print("Name: ");
        user.setName(sc.next());
        System.out.print("Phone number, it is your password also: ");
        user.setPhoneNumber(sc.next());
        System.out.print("Product name: ");
        ticket.setProductName(sc.next());
        System.out.print("Product model: ");
        ticket.setProductModel(sc.next());
        System.out.print("Product price: ");
        ticket.setProductPrice(sc.nextDouble());
        System.out.println("Notes: ");
        ticket.setNotes(sc.next());
        ticket.setStatus(false);
        UserController.giveItem(user,ticket);
        System.out.println(UserController.toSeeUserInfo(user));
        System.out.println(UserController.toSeeTicketInfo(user));
        return true;
    }

    @Override
    public boolean toControlUser(){
        return false;
    }

    @Override
    public boolean toControlUser(String name, String password) {
        sc = new Scanner(System.in);
        user = new User();
        user.setName(name);
        user.setPhoneNumber(password);
        System.out.println("1.Check ticket status\n2.Leave comment\n3.Take item back\n" +
                "4.Change user info\n5.Change ticket info ");
        switch (sc.nextInt()) {
            case 1:
                if (UserController.checkTicketStatus(user) == true) {
                    System.out.println("Item is repaired");
                    return true;
                } else {
                    System.out.println("Item is not repaired");
                    return false;
                }
            case 2:
                System.out.println("Your comment");
                UserController.leaveComment(user,sc.next());
                return true;
            case 3:
                if (UserController.takeItemBack(user) == true) {
                    if (UserController.checkTicketStatus(user) == true) {
                        System.out.println("You have got item\nItem is repaired");
                    } else {
                        System.out.println("You have not got item\nItem is not repaired");
                    }
                    System.out.println("You have not got item");
                    return true;
                }
                return false;
            case 4:
                User newUser = new User();
                System.out.print("Name: ");
                newUser.setName(sc.next());
                System.out.print("Phone number, it is your password also: ");
                newUser.setPhoneNumber(sc.next());
                UserController.changeUserInfo(user,newUser);
                System.out.println(UserController.toSeeUserInfo(newUser));
                return true;
            case 5:
                Ticket newTicket = new Ticket();
                System.out.print("Product name: ");
                newTicket.setProductName(sc.next());
                System.out.print("Product model: ");
                newTicket.setProductModel(sc.next());
                System.out.print("Product price: ");
                newTicket.setProductPrice(sc.nextDouble());
                System.out.println("Notes: ");
                newTicket.setNotes(sc.next());
                newTicket.setStatus(false);
                UserController.changeTicketInfo(user, newTicket);
                System.out.println(UserController.toSeeTicketInfo(user));
                return true;
            default:
                System.out.println("Invalid command");
                return false;
        }
    }

}
