package week3.mvc.dao;

import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;
import java.util.List;

public interface TicketDao {

    Ticket createTicket(Item item, int fixHours);

    List<Ticket> getOpenTickets();

    Ticket findTicketById(int id);

    Ticket getNextOpenTicket();

    List<Ticket> getClosedTickets();

    List<Ticket> getAllTickets();

    boolean addTickets(List<Ticket> tickets);

    boolean updateTicket(Ticket ticket, int newFixHours) throws Exception;

    boolean closeTicket(Ticket ticket);

}
