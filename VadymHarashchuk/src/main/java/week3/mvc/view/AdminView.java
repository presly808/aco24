package week3.mvc.view;

import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Ticket;

import java.util.List;
import java.util.Map;

public interface AdminView {

    void login();

    boolean hireWorker(Worker worker);

    Worker fireWorker(Worker worker) throws Exception;

    void paySalary();

    Map<String, Double> getSalaryInfoByWorkers();

    int getWorkedHoursByWorker(Worker worker);

    List<Worker> getInvolvedWorkers();

    List<Ticket> getclosedTickets();

    List<Ticket> getOpenTickets();

}
