package week3.servicecenter.proxyController;

import week3.servicecenter.controller.AdminController;
import week3.servicecenter.model.Human;
import week3.servicecenter.model.Worker;

import java.util.List;

public class AdminProxyController implements AdminController {

    private AdminController adminController;

    private AdminProxyController(AdminController adminController){
        this.adminController = adminController;
    }

    public boolean hireWorker(Worker worker){

    }

    public List<Human> read(){

    }

    public void update(){

    }

    public boolean fireWorker(Worker worker){

    }

    public void paySalary(){

    }

    public Double getSalaryInfoByWorkers(){

    }

    public void getWorkedHoursByWorker(){

    }

    public void otherFilteringActionsOverWorkersTicketsUsers(){

    }
}
