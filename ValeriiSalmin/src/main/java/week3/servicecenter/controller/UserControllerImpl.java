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
    public String checkTicketStatus(int id) {
        return ticketDao.getStatus(id);
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
    public boolean leaveComment(int id, String comment) {
        for (Ticket ticket: ticketDao.read()) {
            if (ticket.getId() == id){
                ticket.setComment(comment);
                return true;
            }
        }
        return false;
    }
}
