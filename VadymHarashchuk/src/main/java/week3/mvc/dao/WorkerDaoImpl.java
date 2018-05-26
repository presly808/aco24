package week3.mvc.dao;

import week3.mvc.controller.ServiceFactory;
import week3.mvc.db.DataBase;
import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Ticket;

import java.util.List;

public class WorkerDaoImpl implements Dao<Worker> {

    DataBase database;

    public WorkerDaoImpl() {
        database = (DataBase) ServiceFactory.getBean("database");
    }

    public boolean create(Worker worker) {
        return database.getWorkers().add(worker);
    }

    @Override
    public List<Worker> find(String key) {
        return null;
    }

    public List<Worker> getAll() {
        return database.getWorkers();
    }

    public Worker update(Worker worker, String phone, List<Ticket> tickets, double...salary) {

        int index = database.getWorkers().indexOf(worker);

        worker.setPhoneNumber(phone);
        worker.setSalary(salary[0]);
        worker.setTickets(tickets);

        return database.getWorkers().set(index, worker);
    }

    public boolean delete(Worker worker) throws Exception {

        if (database.getWorkers().indexOf(worker) >= 0) {
            return database.getWorkers().remove(worker);
        }
        throw new Exception("There is no such worker in the database");
    }

}
