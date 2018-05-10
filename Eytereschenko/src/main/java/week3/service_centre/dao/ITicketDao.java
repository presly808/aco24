package week3.service_centre.dao;

import week3.service_centre.model.Client;
import week3.service_centre.model.Order;
import week3.service_centre.model.Ticket;

import java.util.List;

public interface ITicketDao {

    int createTicket(Client client, Order order);

    Ticket readTicket(int id);

    boolean updateTicket(Ticket updatedTicket);

    boolean deleteTicket(int id);

    List<Ticket> showAllTickets();

}
