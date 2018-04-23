package week3.servicecenter.dao;

import week3.servicecenter.model.Ticket;

public interface TicketDao {

    public Ticket create();
    public void read();
    public void update();
    public void delete(int id);
}
