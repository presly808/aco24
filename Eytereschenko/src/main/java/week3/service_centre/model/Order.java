package week3.service_centre.model;

import java.util.Date;

public class Order {

    private int orderId;
    private Client client;
    private OrderStatus status;
    private Date createTime;


    private static int lastOrderId;

    enum OrderStatus {NEW, IN_PROGRESS, CLOSED_SUCCESSFUL, UNSUCCESSFUL}

    public Order(Client client) {

        this.orderId = lastOrderId++;
        this.client = client;
        this.status = OrderStatus.NEW;
        this.createTime = new Date();

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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
