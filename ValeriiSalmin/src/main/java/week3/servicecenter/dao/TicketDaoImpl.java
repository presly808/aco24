package week3.servicecenter.dao;

import week3.servicecenter.model.Ticket;

public class TicketDaoImpl implements TicketDao {

    @Override
    public Ticket create() {
        return new Ticket();
    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete(int id) {
        ticket = null;
    }
}
