package week3.mvc.controller;

import week3.mvc.dao.*;
import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Ticket;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdminControllerImpl implements AdminController {

    //DAO for work with database
    LogDao logDao;
    TicketDao ticketDao;
    UserDao userDao;
    WorkerDao workerDao;

    public AdminControllerImpl() {
        ticketDao = (TicketDao) ServiceFactory.get("ticketDao");
        userDao = (UserDao) ServiceFactory.get("userDao");
        workerDao = (WorkerDao) ServiceFactory.get("workerDao");
    }

    public boolean hireWorker(Worker worker) {
        System.out.printf("Worker %s is hired.\n", worker.getName());
        return workerDao.createWorker(worker);
    }

    public boolean fireWorker(Worker worker) throws Exception {
        return workerDao.deleteWorker(worker);
    }

    public void paySalary() {

    }

    public Map<String, Double> getSalaryInfoByWorkers() {

        return workerDao.getAllWorkers().stream()
                .collect(Collectors.toMap(Worker::getName, Worker::getSalary));
    }

    public int getWorkedHoursByWorker(Worker worker) {

        return workerDao.getAllWorkers().stream()
                .filter(worker1 -> worker1.equals(worker)).map(Worker::getHours).findFirst().get();
    }

    public List<Worker> getInvolvedWorkers() {

        return null;
    }

    public List<Ticket> getclosedTickets() {

        return ticketDao.getClosedTickets();
    }

    public List<Ticket> getOpenTickets() {

        return ticketDao.getOpenTickets();
    }

}
