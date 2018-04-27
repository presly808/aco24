package week3.mvc.db;

import week3.mvc.model.human.User;
import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private List<User> users;
    private List<Worker> workers;
    private List<Ticket> tickets;
    private List<Item> items;


    public DataBase(){
        users = new ArrayList<>();
        workers = new ArrayList<>();
        tickets = new ArrayList<>();
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
