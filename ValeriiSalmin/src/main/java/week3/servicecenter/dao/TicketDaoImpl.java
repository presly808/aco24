package week3.servicecenter.dao;

import week3.servicecenter.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements TicketDao {

    private Ticket ticket;

    private TicketDaoImpl(){

    }



    @Override
    public Ticket create() {
        return new Ticket();
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
