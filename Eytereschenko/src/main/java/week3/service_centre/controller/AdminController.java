package week3.service_centre.controller;

import week3.service_centre.dao.OrderDao;
import week3.service_centre.dao.TicketDao;
import week3.service_centre.dao.WorkerDao;
import week3.service_centre.db.Database;
import week3.service_centre.model.Order;
import week3.service_centre.model.Status;
import week3.service_centre.model.Ticket;
import week3.service_centre.model.Worker;
import week3.service_centre.model.utilits.DataValidator;

import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.List;

public class AdminController implements IAdminController {

    private WorkerDao workerDao;
    private TicketDao ticketDao;
    private OrderDao orderDao;

    public AdminController(WorkerDao workerDao, TicketDao ticketDao, OrderDao orderDao) {
        this.workerDao = workerDao;
        this.ticketDao = ticketDao;
        this.orderDao = orderDao;
    }

    @Override
    public boolean loginInto(String login, String password) {
        // TODO: 10.05.2018
        return false;
    }

    @Override
    public boolean hireWorker(String name, int age, String login, String password, double salary) {

        if (DataValidator.checkName(name) && DataValidator.checkWorkersLogin(login)) {
            workerDao.create(name, age, login, password, salary);
            return true;
        }

        return false;
    }

    @Override
    public Ticket createTicketFromOrder(Order order) throws Exception {
        if (order != null) {
            int ticketId = ticketDao.createTicket(order.getClient(), order);
            return ticketDao.readTicket(ticketId);
        } else {
            throw new Exception("order is null!");
        }

    }

    @Override
    public boolean fireWorker(int id) {

        Worker workerToBeFired = workerDao.read(id);
        if (workerToBeFired == null) {
            System.out.println("there is no worker with id = " + id);
            return false;
        }
        List<Ticket> ticketList = workerToBeFired.getWorkerTickets();
        if (ticketList != null) {
            workerDao.delete(workerToBeFired);
            // TODO: 10.05.2018
            // assignTicketsRandom(ticketList);
        } else {
            workerDao.delete(workerToBeFired);
        }
        return true;
    }

    @Override
    public List<Order> seeAllOrdersInSomeStatus(Status status) {

        List<Order> resultList = new ArrayList<>();
        for (int i = 0; i < Database.orders.size(); i++) {
            if (Database.orders.get(i).getStatus().equals(status)) {
                resultList.add(Database.orders.get(i));
            }
        }

        return resultList;
    }

    @Override
    public List<Ticket> seeAllTicketsInSomeStatus(Status status) {

        List<Ticket> resultList = new ArrayList<>();
        for (int i = 0; i < Database.tickets.size(); i++) {
            if (Database.tickets.get(i).getStatus() == status) {
                resultList.add(Database.tickets.get(i));
            }
        }

        return resultList;
    }
}
