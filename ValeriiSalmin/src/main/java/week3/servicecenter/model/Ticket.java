package week3.servicecenter.model;

public class Ticket {

    private static int id;
    private Worker worker;
    private User user;
    private Item item;
    private String status;

    public Ticket(Item item, User user){
        id++;
        this.item = item;
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

}
