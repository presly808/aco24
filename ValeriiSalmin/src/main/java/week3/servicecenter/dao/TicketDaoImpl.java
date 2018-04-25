package week3.servicecenter.dao;

import week3.servicecenter.model.DB;
import week3.servicecenter.model.Item;
import week3.servicecenter.model.Ticket;
import week3.servicecenter.model.User;
import week3.servicecenter.utils.ObjectFactory;

import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements TicketDao {

    private Ticket ticket;
    private DB db;

    public TicketDaoImpl(){
        db = (DB) ObjectFactory.get("DB");
    }

    @Override
    public void leaveComment(int id, String comment){
        ticket.setComment(comment);
    }

    @Override
    public String getStatus(int id){
        return ticket.getStatus();
    }

    @Override
    public boolean create(Item item, User user) {
        return false;
    }

    @Override
    public List<Ticket> read() {
        return new ArrayList<Ticket>();
    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
