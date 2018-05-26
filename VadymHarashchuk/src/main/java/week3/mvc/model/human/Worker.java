package week3.mvc.model.human;

import week3.mvc.controller.ServiceFactory;
import week3.mvc.dao.TicketDao;
import week3.mvc.model.repair.Ticket;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Worker implements Human {

    private String name;
    private String phoneNumber;
    private String password;
    private TicketDao tickets;
    private double salary;
    private LocalDate startWorkDate;
    private int hours;
    private static final String type = "WORKER";

    public Worker(String name, String phoneNumber, double salary) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.startWorkDate = LocalDate.now();
        tickets = (TicketDao) ServiceFactory.getBean("ticketDao");
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Ticket> getTickets() {
        return tickets.getAllTickets();
    }

    public String getType() {
        return type;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets.getAllTickets().addAll(tickets);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getStartWorkDate() {
        return startWorkDate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Double.compare(worker.salary, salary) == 0 &&
                Objects.equals(name, worker.name) &&
                Objects.equals(phoneNumber, worker.phoneNumber) &&
                Objects.equals(tickets, worker.tickets) &&
                Objects.equals(startWorkDate, worker.startWorkDate);
    }

}
