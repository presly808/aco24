package week3.service_centre.dao;

import week3.service_centre.model.Worker;

public interface IWorkerDao {

    int create(String name, int age, String login, String password, double salary);

    Worker read(int id);

    boolean update(Worker updatedWorker);

    boolean delete(Worker worker);

}
