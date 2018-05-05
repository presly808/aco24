package week3.mvc.controller;

import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

public interface WorkerController {

    void takeForRepair(Item item);
    boolean repairItem(Ticket ticket);
    boolean backAfterRepair(Ticket ticket);
}
