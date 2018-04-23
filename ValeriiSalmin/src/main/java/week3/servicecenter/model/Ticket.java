package week3.servicecenter.model;

public class Ticket {

    private Worker worker;
    private User user;
    private Item item;

    private Ticket(Item item, User user){
        this.item = item;
        this.user = user;
    }


}
