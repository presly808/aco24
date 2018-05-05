package week3.mvc.controller;

import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

public interface UserController {

    Ticket giveItem(Item item);

    String checkTicketStatus(Ticket ticket);

    Item takeItemBack(Ticket ticket);

    void leaveComment(String string);

}
