package week8.servicecentre.dao;

import week8.servicecentre.model.Ticket;
import week8.servicecentre.model.User;

import java.util.List;
import java.util.Map;

public class TicketDao implements Dao<Ticket> {
    @Override
    public boolean create(Ticket ticket) throws Exception {
        for (Map.Entry<User, Ticket> entry:
                DB.users.entrySet()) {
            if (entry.getKey().getId().equals(ticket.getId())) {
                System.out.println(entry.getKey().getName());
                entry.setValue(ticket);
                return true;
            }
        }
        throw new Exception();
    }

    @Override
    public Ticket read(Ticket ticket) throws Exception{
        for (Map.Entry<User, Ticket> entry:
                DB.users.entrySet()) {
            if (ticket.getId().equals(entry.getValue().getId())) {
                return entry.getValue();
            }
        }
        throw new Exception();
    }

    @Override
    public boolean update(Ticket updatedTicket) throws Exception{
        for (Map.Entry<User, Ticket> entry:
                DB.users.entrySet()) {
            if (updatedTicket.getId().equals(entry.getValue().getId())) {
                DB.users.replace(entry.getKey(), entry.getValue(), updatedTicket);
                return true;
            }
        }
        throw new Exception();
    }

    @Override
    public boolean delete(String id) throws Exception{
        for (Map.Entry<User, Ticket> entry:
                DB.users.entrySet()) {
            if (id.equals(entry.getValue().getId())) {
                entry.setValue(new Ticket());
                return true;
            }
        }
        return false;
    }
}
