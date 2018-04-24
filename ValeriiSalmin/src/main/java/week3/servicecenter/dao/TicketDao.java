package week3.servicecenter.dao;

import week3.servicecenter.model.Item;
import week3.servicecenter.model.Ticket;
import week3.servicecenter.model.User;

import java.util.List;

public interface TicketDao {

    public boolean create(Item item, User user);
    public List<Ticket> read();
    public boolean update(int id);
    public boolean delete(int id);
    public String getStatus(int id);
    public void leaveComment(int id, String comment);
}
