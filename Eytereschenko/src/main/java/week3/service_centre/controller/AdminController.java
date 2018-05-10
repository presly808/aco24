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

import java.util.ArrayList;
import java.util.List;

public class AdminController implements IAdminController {

    WorkerDao workerDao = new WorkerDao();
    TicketDao ticketDao = new TicketDao();
    OrderDao orderDao = new OrderDao();

    @Override
    public boolean hireWorker(String name, int age, String login, String password, double salary) {

        if(DataValidator.checkName(name) && DataValidator.checkWorkersLogin(login)){
            workerDao.create(name, age, login, password, salary);
            return true;
        }

        return false;
    }

    @Override
    public Ticket createTicketFromOrder(Order order) {
        return null;
    }

    @Override
    public boolean fireWorker(int id) {
        return false;
    }

    @Override
    public List<Order> seeAllOrdersInSomeStatus(Status status) {

        List<Order> resultList = new ArrayList<>();
        for(int i = 0; i < Database.orders.size(); i++){
            if(Database.orders.get(i).getStatus().equals(status)){
                resultList.add(Database.orders.get(i));
            }
        }

        return resultList;
    }

    @Override
    public List<Ticket> seeAllTicketsInSomeStatus(Status status) {

        List<Ticket> resultList = new ArrayList<>();
        for(int i = 0; i < Database.tickets.size(); i++){
            if(Database.tickets.get(i).getStatus() == status){
                resultList.add(Database.tickets.get(i));
            }
        }

        return resultList;
    }
}
