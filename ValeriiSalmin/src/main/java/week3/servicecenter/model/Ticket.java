package week3.servicecenter.model;

public class Ticket {

    private static int ID_COUNT=1;
    private int id;
    private Worker worker;
    private User user;
    private Item item;
    private String status;
    private String comment;

    public Ticket(Item item, User user){
        this.item = item;
        this.user = user;
    }

    public int getId() {
        return id;
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

    public void setComment(String comment) {
        this.comment = comment;
    }
}
