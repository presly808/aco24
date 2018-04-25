package week3.servicecenter.controller;

import week3.servicecenter.model.Human;
import week3.servicecenter.model.Worker;

import java.util.List;

public interface AdminController {

    public boolean hireWorker(Worker worker);
    public List<Human> read();
    public void update();
    public boolean fireWorker(Worker worker);
    public void paySalary();
    public Double getSalaryInfoByWorkers();
    public void getWorkedHoursByWorker();
    public void otherFilteringActionsOverWorkersTicketsUsers();
}
