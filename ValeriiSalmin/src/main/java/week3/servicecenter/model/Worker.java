package week3.servicecenter.model;

import java.util.Date;

public class Worker extends Human {

    private Double salary;
    private Date startWorkDate;

    public Worker(String name, String phoneNumber, Double salary, Date startWorkDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.startWorkDate = startWorkDate;
    }

    private void takeForRepair(Item item){

    }

    private void repairItem(){

    }

    private void backAfterRepair(){

    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }
}
