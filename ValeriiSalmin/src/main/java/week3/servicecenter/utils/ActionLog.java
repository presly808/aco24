package week3.servicecenter.utils;

import week3.servicecenter.model.Item;
import week3.servicecenter.model.Ticket;
import week3.servicecenter.model.User;
import week3.servicecenter.model.Worker;

public class ActionLog {


    private User user;
    private Item item;
    private Ticket ticket;
    private Worker worker;

    public ActionLog(User user, Item item, Ticket ticket, Worker worker) {
        this.user = user;
        this.item = item;
        this.ticket = ticket;
        this.worker = worker;
    }

    public void addToLog(){

    }
}
