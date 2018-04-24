package week3.servicecenter.dao;

import week3.servicecenter.model.Worker;

import java.util.Date;
import java.util.List;

public interface WorkerDao {

    public boolean create(Worker worker);
    public List<Worker> read();
    public void update(Worker worker);
    public boolean delete(Worker worker);
}
