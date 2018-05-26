package week8.servicecentre.controller;

import org.eclipse.jetty.util.DateCache;
import week8.servicecentre.dao.Dao;
import week8.servicecentre.dao.TicketDao;
import week8.servicecentre.model.Ticket;

public class TicketController implements ITicketController {
    private Dao ticketDao;
    private Ticket ticket;

    @Override
    public boolean giveItem(String name, String model, double price, String id) throws Exception {
        ticketDao = new TicketDao();
        ticket = new Ticket();
        ticket.setProductName(name);
        ticket.setProductModel(model);
        ticket.setProductPrice(price);
        ticket.setRepairingPrice(price * 0.1);
        ticket.setStatus(true);
        ticket.setId(id);
        return ticketDao.create(ticket);
    }

    @Override
    public boolean takeItem(String id) throws Exception{
        return ticketDao.delete(id);
    }
}
