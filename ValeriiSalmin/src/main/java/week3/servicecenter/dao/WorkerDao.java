package week3.servicecenter.dao;

import week3.servicecenter.model.Worker;

import java.util.Date;
import java.util.List;

public interface WorkerDao {

    public Worker create(String name, String phoneNumber, String salary, Date startWorkDate);
    public List<Worker> read();
    public boolean update(String name);
    public boolean delete(String name);
}
