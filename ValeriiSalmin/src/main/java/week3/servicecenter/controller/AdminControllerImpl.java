package week3.servicecenter.controller;

import week3.servicecenter.dao.TicketDao;
import week3.servicecenter.dao.UserDao;
import week3.servicecenter.dao.WorkerDao;

public class AdminControllerImpl implements AdminController {

    private WorkerDao workerDao;
    private UserDao userDao;
    private TicketDao ticketDaoDao;


    public AdminControllerImpl(WorkerDao workerDao, UserDao userDao, TicketDao ticketDaoDao) {
        this.workerDao = workerDao;
        this.userDao = userDao;
        this.ticketDaoDao = ticketDaoDao;
    }

    @Override
    public void create() {

    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
