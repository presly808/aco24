package week3.controller;

import week3.model.Ticket;

public interface WorkerController {

    public boolean createWorkerAccount(String name, String phoneNumber, int password);
    public Ticket repairItem(int workerId, int password, int itemId);
    public Ticket backAfterRepair(int workerId, int password, int itemId);

}
