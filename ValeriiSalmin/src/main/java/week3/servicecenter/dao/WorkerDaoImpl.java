package week3.servicecenter.dao;

import week3.servicecenter.model.DB;
import week3.servicecenter.model.Worker;
import week3.servicecenter.utils.ObjectFactory;

import java.util.List;

public class WorkerDaoImpl implements WorkerDao {

    private DB db;

    public WorkerDaoImpl(){
         db = (DB)ObjectFactory.get("DB");
    }

    @Override
    public boolean create(Worker worker) {
        return db.getWorkerList().add(worker);
    }

    @Override
    public List<Worker> read() {
        return db.getWorkerList();
    }

    @Override
    public void update(Worker worker) {

    }

    @Override
    public boolean delete(Worker worker) {
        return db.getWorkerList().remove(worker);
    }
}
