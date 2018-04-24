package week3.servicecenter.model;

public class Item {

    private int id;
    private String name;
    private User user;
    private Worker worker;
    private Ticket ticket;
    private boolean fixed;

    protected Item(String name, User user, Ticket ticket){
        this.name = name;
        this.user = user;
        this.ticket = ticket;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setFixed() {
        this.fixed = true;
    }
}
