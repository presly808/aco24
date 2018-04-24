package week3.servicecenter.dao;

import week3.servicecenter.model.Worker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkerDaoImpl implements WorkerDao {

    @Override
    public Worker create(String name, String phoneNumber, String salary, Date startWorkDate) {
        return new Worker(name, phoneNumber, salary, startWorkDate);
    }

    @Override
    public List<Worker> read() {
        return new ArrayList<Worker>();
    }

    @Override
    public boolean update(String name) {
        return false;
    }

    @Override
    public boolean delete(String name) {
        return false;
    }
}
