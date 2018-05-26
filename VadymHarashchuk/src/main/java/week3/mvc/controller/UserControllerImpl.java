package week3.mvc.controller;

import week3.mvc.dao.ItemDao;
import week3.mvc.dao.TicketDao;
import week3.mvc.exceptions.LoginException;
import week3.mvc.exceptions.RegisterException;
import week3.mvc.model.human.User;
import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

import java.util.Arrays;
import java.util.Map;

public class UserControllerImpl implements UserController {


    TicketDao tickets;
    ItemDao items;

    public UserControllerImpl(){
        tickets = (TicketDao) ServiceFactory.getBean("ticketDao");
        items = (ItemDao) ServiceFactory.getBean("itemDao");
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
