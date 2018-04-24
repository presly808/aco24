package week3.servicecenter.dao;

import week3.servicecenter.model.Worker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkerDaoImpl implements WorkerDao {

    private final List<Worker> workerList;

    private WorkerDaoImpl(){
        this.workerList = new ArrayList<>();
    }

    @Override
    public boolean create(Worker worker) {
        return workerList.add(worker);
    }

    @Override
    public List<Worker> read() {
        return workerList;
    }

    @Override
    public void update(Worker worker) {

    }

    @Override
    public boolean delete(Worker worker) {
        return workerList.remove(worker);
    }
}
