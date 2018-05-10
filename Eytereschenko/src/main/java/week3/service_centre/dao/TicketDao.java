package week3.service_centre.dao;

import week3.service_centre.db.Database;
import week3.service_centre.model.Client;
import week3.service_centre.model.Order;
import week3.service_centre.model.Ticket;

import java.util.List;

public class TicketDao implements ITicketDao {



    @Override
    public int createTicket(Client client, Order order) {

        if(client == null){
            System.out.println("Client is null!");
            return -1;
        }else if(order == null){
            System.out.println("Null order");
            return -1;
        }

        Ticket ticket = new Ticket(client, order.getOrderId());
        Database.tickets.add(ticket);

        return ticket.getOrderId();

    }

    @Override
    public Ticket readTicket(int id) {

        if(id <= 0){
            System.out.println("Incorrect entered value");
            return null;
        }

        for (int i = 0; i < Ticket.getLastTicketNo(); i++) {
            if(Database.tickets.get(i).getTicketId() == id){
                return Database.tickets.get(i);
            }
        }
        System.out.println("There is no Ticket with id =" + id);
        return null;
    }

    @Override
    public boolean updateTicket(Ticket updatedTicket) {
        Ticket oldTicket = readTicket(updatedTicket.getTicketId());
        if(oldTicket == null) {
            return false;
        }

        int index = Database.tickets.indexOf(oldTicket);
        Database.tickets.set(index, oldTicket);

        return true;
    }

    @Override
    public boolean deleteTicket(int id) {

        return Database.tickets.remove(readTicket(id));

    }

    @Override
    public List<Ticket> showAllTickets() {

        return Database.tickets;

    }
}
