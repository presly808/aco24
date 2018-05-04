package week3.service_centre.model;

import java.util.Date;

public class Ticket {

    private int ticketId;
    private Client client;
    private int orderId;
    private TicketStatus status;
    private Date createTicketTime;
    private Date backTime;


    private static int lastTicketNo;

    enum TicketStatus {NEW, IN_PROGRESS, FIXED, FINISHED_WITHOUT_FIXING}


    public Ticket(Client client, int orderId) {

        this.ticketId = lastTicketNo++;
        this.client = client;
        this.orderId = orderId;
        this.status = TicketStatus.NEW;
        this.createTicketTime = new Date();

    }

    public static int getLastTicketNo() {
        return lastTicketNo;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Date getCreateTicketTime() {
        return createTicketTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime() {
        this.backTime = new Date();
    }
}
