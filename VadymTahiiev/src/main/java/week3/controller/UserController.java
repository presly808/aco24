package week3.controller;

import week3.model.*;

public interface UserController {

    public boolean createUserAccount(String name, String phoneNumber, int password);
    public Ticket giveItem(String productName, String productModel, double productPrice,
                           String notes, int id, int password);
    public boolean checkTicketStatus(int id, int password);
    public Ticket takeItemBack(int id, int password);
    public String leaveComment(int id, int password, String comment);

}
