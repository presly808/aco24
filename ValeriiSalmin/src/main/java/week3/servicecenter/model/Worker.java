package week3.servicecenter.model;

import java.util.Date;

public class Worker extends Human {

    private String salary;
    private Date startWorkDate;

    public Worker(String name, String phoneNumber, String salary, Date startWorkDate) {
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
}
