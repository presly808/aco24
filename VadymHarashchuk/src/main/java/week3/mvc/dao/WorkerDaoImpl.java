package week3.mvc.dao;

import week3.mvc.controller.ServiceFactory;
import week3.mvc.db.DataBase;
import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Ticket;

import java.util.List;

public class WorkerDaoImpl implements WorkerDao {

    DataBase database;

    public WorkerDaoImpl() {
        database = (DataBase) ServiceFactory.get("database");
    }

    public boolean createWorker(Worker worker) {
        return database.getWorkers().add(worker);
    }

    public List<Worker> getAllWorkers() {
        return database.getWorkers();
    }

    public Worker updateWorker(Worker worker, String phone, double salary, List<Ticket> tickets) {

        int index = database.getWorkers().indexOf(worker);

        worker.setPhoneNumber(phone);
        worker.setSalary(salary);
        worker.setTickets(tickets);

        return database.getWorkers().set(index, worker);
    }

    public boolean deleteWorker(Worker worker) throws Exception {

        if (database.getWorkers().indexOf(worker) >= 0) {
            return database.getWorkers().remove(worker);
        }
        throw new Exception("There is no such worker in the database");
    }

}
