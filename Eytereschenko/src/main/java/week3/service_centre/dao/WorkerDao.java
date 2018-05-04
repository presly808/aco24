package week3.service_centre.dao;

import week3.service_centre.db.Database;
import week3.service_centre.model.Worker;
import week3.service_centre.model.utilits.DataValidator;

public class WorkerDao implements IWorkerDao {
    @Override
    public int create(String name, int age, String login, String password, double salary) {

        if(!DataValidator.checkName(name)){
            System.out.println("Incorrect name");
            return -1;
        }

        Worker newWorker = new Worker(name, age, login, password, salary);
        Database.workers.add(newWorker);

        return newWorker.getId();
    }

    @Override
    public Worker read(int id) {

        if(id <= 0){
            System.out.println("Enter ID > 0");
            return null;
        }

        for (int i = 0; i < Worker.getLastWorkerId(); i++) {
            if(Database.workers.get(i).getId() == id){
                return Database.workers.get(i);
            }
        }

        System.out.println("There is no Worker with id =" + id);
        return null;
    }

    @Override
    public boolean update(Worker updatedWorker) {
        Worker oldWorker = read(updatedWorker.getId());
        int index = Database.workers.indexOf(oldWorker);
        return Database.workers.set(index, updatedWorker) != null;

    }

    @Override
    public boolean delete(Worker worker) {
       return Database.workers.remove(worker);
    }
}
