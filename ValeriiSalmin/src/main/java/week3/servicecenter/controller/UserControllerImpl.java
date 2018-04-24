package week3.servicecenter.controller;

import week3.servicecenter.dao.TicketDao;
import week3.servicecenter.model.Item;
import week3.servicecenter.model.Ticket;

public class UserControllerImpl implements UserController {

    private TicketDao ticketDao;

    private UserControllerImpl(TicketDao ticketDao){
        this.ticketDao = ticketDao;
    }

    @Override
    public String checkTicketStatus(Ticket ticket) {
        return ticketDao.getStatus();
    }

    @Override
    public boolean giveItem(Item item) {
        return false;
    }

    @Override
    public boolean takeItemBack(Item item) {
        return false;
    }

    @Override
    public boolean leaveComment(Ticket ticket, String comment) {
        return false;
    }


}
