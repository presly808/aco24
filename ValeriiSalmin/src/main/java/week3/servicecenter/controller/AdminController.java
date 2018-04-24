package week3.servicecenter.controller;

import week3.servicecenter.model.Worker;

import java.util.List;

public interface AdminController {

    public void hireWorker();
    public List<Worker> read();
    public void update();
    public void fireWorker();
}
