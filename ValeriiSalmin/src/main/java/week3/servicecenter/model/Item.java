package week3.servicecenter.model;

public class Item {

    private String name;
    private User user;
    private Worker worker;
    private Ticket ticket;

    protected Item(String name, User user, Ticket ticket){
        this.name = name;
        this.user = user;
        this.ticket = ticket;
    }

}
