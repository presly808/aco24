package week3.servicecenter.controller;

import week3.servicecenter.dao.TicketDao;
import week3.servicecenter.dao.UserDao;
import week3.servicecenter.dao.WorkerDao;
import week3.servicecenter.model.Human;
import week3.servicecenter.model.Worker;
import week3.servicecenter.utils.ObjectFactory;

import java.util.List;

public class AdminControllerImpl implements AdminController {

    private WorkerDao workerDao;
    private UserDao userDao;
    private TicketDao ticketDao;

    public AdminControllerImpl() {
        workerDao = (WorkerDao)ObjectFactory.get("WorkerDao");
        ticketDao = (TicketDao)ObjectFactory.get("TicketDao");
        userDao = (UserDao)ObjectFactory.get("UserDao");
    }

    @Override
    public boolean hireWorker(Worker worker) {
        return workerDao.create(worker);
    }

    @Override
    public List<Human> read() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public boolean fireWorker(Worker worker) {
        return workerDao.delete(worker);
    }

    @Override
    public void paySalary() {

    }

    @Override
    public Double getSalaryInfoByWorkers() {
        Double salarySum = 0.0;

        for (Worker worker:workerDao.read()) {
            salarySum+=worker.getSalary();
        }
        return salarySum;
    }

    @Override
    public void getWorkedHoursByWorker() {

    }

    @Override
    public void otherFilteringActionsOverWorkersTicketsUsers() {

    }
}
