package week3.servicecenter.dao;

import week3.servicecenter.model.Ticket;

import java.util.List;

public interface TicketDao {

    public Ticket create();
    public List<Ticket> read();
    public boolean update(int id);
    public boolean delete(int id);
}
