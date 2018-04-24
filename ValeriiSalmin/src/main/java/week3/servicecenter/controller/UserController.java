package week3.servicecenter.controller;

import week3.servicecenter.model.Item;
import week3.servicecenter.model.Ticket;

public interface UserController {

    public String checkTicketStatus(Ticket ticket);
    public boolean giveItem(Item item);
    public boolean takeItemBack(Item item);
    public boolean leaveComment(Ticket ticket, String comment);
}
