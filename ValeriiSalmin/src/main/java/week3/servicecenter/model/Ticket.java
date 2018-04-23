package week3.servicecenter.model;

public class Ticket {

    private int id;
    private Worker worker;
    private User user;
    private Item item;

    public Ticket(Item item, User user){
        id++;
        this.item = item;
        this.user = user;
    }


}
