package week3.servicecenter.controller;

import week3.servicecenter.dao.ItemDao;
import week3.servicecenter.dao.TicketDao;
import week3.servicecenter.model.Item;
import week3.servicecenter.model.Ticket;
import week3.servicecenter.utils.ObjectFactory;

public class UserControllerImpl implements UserController {

    private TicketDao ticketDao;
    private ItemDao itemDao;

    public UserControllerImpl(){
        this.ticketDao = (TicketDao) ObjectFactory.get("TicketDao");
        this.itemDao = (ItemDao) ObjectFactory.get("ItemDao");
    }

    @Override
    public String checkTicketStatus(int id) {
        return ticketDao.getStatus(id);
    }

    @Override
    public boolean giveItem(Item item) {
        return itemDao.create(item);
    }

    @Override
    public boolean takeItemBack(Item item) {
        return itemDao.delete(item);
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
