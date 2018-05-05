package week3.mvc.dao;

import week3.mvc.controller.ServiceFactory;
import week3.mvc.db.DataBase;
import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public class TicketDaoImpl implements TicketDao {

    DataBase database;

    public TicketDaoImpl() {
        database = (DataBase) ServiceFactory.get("database");
    }

    public Ticket createTicket(Item item, int fixHours) {

        Ticket ticket = new Ticket(item, fixHours);

        if (database.getTickets().add(ticket)) {
            return ticket;
        }

        return null;
    }

    public List<Ticket> getOpenTickets() {
        return database.getTickets()
                .stream()
                .filter(ticket -> ticket.getStatus().equals("open"))
                .collect(Collectors.toList());
    }

    public Ticket findTicketById(int id) {
        return database.getTickets()
                .stream()
                .filter(ticket -> ticket.getId() == id)
                .findFirst().get();
    }

    public Ticket getNextOpenTicket() {
        return database.getTickets()
                .stream()
                .filter(ticket -> ticket.getStatus().equals("open"))
                .findFirst().get();
    }

    public List<Ticket> getClosedTickets() {
        return database.getTickets()
                .stream()
                .filter(ticket -> ticket.getStatus().equals("closed"))
                .collect(Collectors.toList());
    }

    public List<Ticket> getAllTickets() {

        return database.getTickets();
    }

    public boolean addTickets(List<Ticket> tickets) {
        return database.getTickets().addAll(tickets);
    }

    public boolean updateTicket(Ticket ticket, int newFixHours) throws Exception {
        int index = database.getTickets().indexOf(ticket);

        ticket.setFixHours(newFixHours);

        if (index >= 0)
            return true;

        throw new Exception("This ticket hasn't been found in database");
    }

    public boolean closeTicket(Ticket ticket) {

        int index = database.getTickets().indexOf(ticket);

        ticket.setStatus("closed");

        if (index >= 0)
            return database.getTickets().set(index, ticket) != null;
        try {
            throw new Exception("This ticket hasn't been found in database");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
