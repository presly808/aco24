package week3.controller;

import week3.model.*;

public class RealWorkerController implements WorkerController {

    @Override
    public boolean createWorkerAccount(String name, String phoneNumber, int password) {
        return false;
    }

    @Override
    public Ticket repairItem(int workerId, int password, int itemId) {
        return null;
    }

    @Override
    public Ticket backAfterRepair(int workerId, int password, int itemId) {
        return null;
    }
}
