package week3.mvc.model.repair;

import week3.mvc.model.human.User;

import java.util.Objects;

public class Ticket {

    private Item item;
    private static int counter = 0;
    private int id;
    private String status;
    private int fixHours;
    private User owner;

    public Ticket(Item item, int fixHours) {
        this.item = item;
        this.fixHours = fixHours;
        id = ++counter;
        status = "open";
    }

    public int getFixHours() {
        return fixHours;
    }

    public void setFixHours(int fixHours) {
        this.fixHours = fixHours;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                Objects.equals(item, ticket.item) &&
                Objects.equals(status, ticket.status);
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
