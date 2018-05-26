package week8.servicecentre.model;

import java.util.Objects;

public class Ticket {
    private String productName;
    private String productModel;
    private double productPrice;
    private double repairingPrice;
    private boolean status;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRepairingPrice() {
        return repairingPrice;
    }

    public void setRepairingPrice(double repairingPrice) {
        this.repairingPrice = repairingPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "productName='" + productName + '\'' +
                ", productModel='" + productModel + '\'' +
                ", productPrice=" + productPrice +
                ", repairingPrice=" + repairingPrice +
                ", status=" + status +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.productPrice, productPrice) == 0 &&
                Double.compare(ticket.repairingPrice, repairingPrice) == 0 &&
                status == ticket.status &&
                id == ticket.id &&
                Objects.equals(productName, ticket.productName) &&
                Objects.equals(productModel, ticket.productModel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productName, productModel, productPrice, repairingPrice, status, id);
    }
}