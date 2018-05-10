package week3.service_centre.controller;

import week3.service_centre.dao.OrderDao;
import week3.service_centre.dao.TicketDao;
import week3.service_centre.db.Database;
import week3.service_centre.model.Order;
import week3.service_centre.model.Status;
import week3.service_centre.model.Ticket;
import week3.service_centre.model.utilits.DataValidator;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkerController implements IWorkerController {

    private TicketDao ticketDao;
    private OrderDao orderDao;


    @Override
    public boolean loginInto(String login, String password) throws LoginException {
        boolean check = false;
        if (DataValidator.checkWorkersLogin(login)) {
            for (int i = 0; i < Database.workers.size(); i++) {
                if (Database.workers.get(i).getLogin().equals(login) &&
                        Database.workers.get(i).getPassword().equals(password)) {
                    check = true;
                    break;
                }
            }
        }
        if (check) {
            Database.logfile.add("Worker " + login + " logged in at " + new Date());
            return true;
        } else {
            throw new LoginException("Incorrect LOGIN or PWD");
        }
    }

    @Override
    public boolean fixItem(int ticketId) {

        Ticket ticket = ticketDao.readTicket(ticketId);

        if (ticket != null) {

            ticket.setStatus(Status.CLOSED_SUCCESSFUL);
            Order order = orderDao.readOrder(ticket.getOrderId());
            order.setStatus(Status.CLOSED_SUCCESSFUL);

            return true;
        }

        return false;
    }
}
