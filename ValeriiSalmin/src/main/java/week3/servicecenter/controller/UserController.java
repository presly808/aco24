package week3.servicecenter.controller;

import week3.servicecenter.model.Item;
import week3.servicecenter.model.Ticket;

public interface UserController {

    public String checkTicketStatus(int id);
    public boolean giveItem(Item item);
    public boolean takeItemBack(Item item);
    public boolean leaveComment(int id, String comment);
}
