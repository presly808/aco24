package week3.mvc.view;

import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

public interface WorkerView {

    void login();
    Item takeForRepair();

    boolean repairItem();

    Item backAfterRepair(Ticket ticket);
}
