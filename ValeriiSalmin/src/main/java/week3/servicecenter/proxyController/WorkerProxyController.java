package week3.servicecenter.proxyController;

import week3.servicecenter.controller.WorkerController;
import week3.servicecenter.controller.WorkerControllerImpl;

public class WorkerProxyController implements WorkerController {

    private WorkerController workerController;

    public WorkerProxyController(WorkerController workerController) {
        this.workerController = workerController;
    }

    public void takeForRepair() {
        System.out.println("bla");
        workerController.takeForRepair();
    }

    public void repairItem() {
        System.out.println("bla");
        workerController.repairItem();
    }

    public void backAfterRepair() {
        System.out.println("bla");
        workerController.backAfterRepair();
    }
}
