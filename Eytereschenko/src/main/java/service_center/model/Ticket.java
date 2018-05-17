package service_center.model;


import java.util.Date;

public class Ticket {

    private String id;
    private Product product;
    private Specialist specialist;
    private Status status;
    private Date createDate;
    private Date finishDate;

    public Ticket(Product product) {
        this.product = product;
        this.status = Status.NEW;
        this.createDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "product=" + product +
                ", status=" + status +
                ", createDate=" + createDate +
                '}';
    }
}
