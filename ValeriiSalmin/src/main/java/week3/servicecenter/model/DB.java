package week3.servicecenter.model;

import java.util.ArrayList;
import java.util.List;

public class DB {

    private List<Ticket> ticketList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private List<Worker> workerList = new ArrayList<>();
    private List<Log> logList = new ArrayList<>();

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }
}
