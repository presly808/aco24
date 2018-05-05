package week3.mvc.controller;

import week3.mvc.dao.ItemDao;
import week3.mvc.dao.TicketDao;
import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

public class UserControllerImpl implements UserController {

    TicketDao tickets;
    ItemDao items;

    public UserControllerImpl(){
        tickets = (TicketDao) ServiceFactory.get("ticketDao");
        items = (ItemDao) ServiceFactory.get("itemDao");
    }


    public Ticket giveItem(Item item) {
        return null;
    }

    public String checkTicketStatus(Ticket ticket) {
        return null;
    }

    public Item takeItemBack(Ticket ticket) {
        return null;
    }

    public void leaveComment(String string) {

    }
}
