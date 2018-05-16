package service_center.dao;

import service_center.model.Ticket;
import service_center.utils.Factory;
import service_center.utils.NumberUtils;

public class TicketDao implements Dao<Ticket> {

    private DbContainer container = Factory.getItem("db");

    public TicketDao() {
    }

    @Override
    public boolean create(Ticket ticket) {

        ticket.setId(NumberUtils.generateId());
        return container.tickets.add(ticket);

    }

    @Override
    public Ticket read(String id) {

        return container.tickets.stream().
                filter(ticket -> ticket.getId().
                        equals(id)).findFirst().orElse(null);

    }

    @Override
    public boolean update(Ticket updatedTicket) {

        int indexArr = container.tickets.indexOf(read(updatedTicket.getId()));
        if(indexArr == -1){
            return false;
        }

        container.tickets.set(indexArr, updatedTicket);

        return true;

    }

    @Override
    public Ticket delete(String id) {

        Ticket ticketToBeDeleted = read(id);

        if(ticketToBeDeleted == null){
            return ticketToBeDeleted;
        }

        container.tickets.remove(ticketToBeDeleted);
        return ticketToBeDeleted;
    }

    @Override
    public Ticket[] all() {
        return container.tickets.toArray(new Ticket[container.tickets.size()]);
    }
}
