package week3.model;

public class Ticket {
    private String productName;
    private String productModel;
    private double productPrice;
    private String notes;
    private boolean status;

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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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
                ", notes='" + notes + '\'' +
                ", status=" + status +
                '}';
    }
}
