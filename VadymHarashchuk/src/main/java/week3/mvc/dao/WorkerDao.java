package week3.mvc.dao;

import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Ticket;

import java.util.List;

public interface WorkerDao {

    boolean createWorker(Worker worker);

    List<Worker> getAllWorkers();

    Worker updateWorker(Worker worker, String phone, double salary, List<Ticket> tickets);

    boolean deleteWorker(Worker worker) throws Exception;
}
