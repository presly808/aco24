package week3.mvc.controller;

import week3.mvc.model.human.User;
import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Ticket;

import java.util.List;
import java.util.Map;

public interface AdminController {

    boolean hireWorker(Worker worker);

    boolean fireWorker(Worker worker) throws Exception;

    void paySalary();

    Map<String, Double> getSalaryInfoByWorkers();

    int getWorkedHoursByWorker(Worker worker);

    List<Worker> getInvolvedWorkers();

    List<Ticket> getclosedTickets();

    List<Ticket> getOpenTickets();

    boolean createUser(User user);

    List<User> findUsers(String key);

}
