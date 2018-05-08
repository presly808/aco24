package week3.service_centre.model;

import java.util.Date;

public class Order {

    private int orderId;
    private Client client;
    private Status status;
    private String product;
    private Date createTime;


    private static int lastOrderId;



    public Order(Client client, String product) {

        this.orderId = lastOrderId++;
        this.client = client;
        this.status = Status.NEW;
        this.createTime = new Date();
        this.product = product;

    }

    public static int getLastOrderId() {
        return lastOrderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getProduct() {
        return product;
    }

}
