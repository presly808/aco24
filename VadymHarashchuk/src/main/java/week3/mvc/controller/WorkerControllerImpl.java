package week3.mvc.controller;

import week3.mvc.dao.TicketDao;
import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

public class WorkerControllerImpl implements WorkerController {

    TicketDao ticketDao;


    public WorkerControllerImpl(){
        ticketDao = (TicketDao) ServiceFactory.getBean("ticketDao");
    }

    public void takeForRepair(Item item) {

    }

    public boolean repairItem(Ticket ticket) {
        return false;
    }

    public boolean backAfterRepair(Ticket ticket) {
        return false;
    }
}
