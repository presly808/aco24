package week3.mvc.view;


import week3.mvc.controller.LoginController;
import week3.mvc.controller.ServiceFactory;
import week3.mvc.dao.TicketDao;
import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

import java.util.Scanner;

public class WorkerView {
    private TicketDao tickets;
    private Ticket workerTicket;
    private Item workerItem;
    private Worker worker;
    private String accessKey;

    private LoginController loginController;

    public WorkerView() {
        loginController = (LoginController) ServiceFactory.get("loginController");
    }


    public void login() {

        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("+You are trying to login as Worker+");
        System.out.println("+++++++++++++++++++++++++++++++++++");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        accessKey = loginController.login("worker", username, password);
        if (accessKey != null) {

            System.out.println("Enter your phone number: ");
            String phone = scanner.nextLine();

            worker = new Worker(username, phone, 8500);
            return;
        }
        try {
            throw new Exception("Credentials aren't correct");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Item takeForRepair(){

        Ticket ticket = tickets.getNextOpenTicket();
        Item item = ticket.getItem();

        workerItem = item;
        workerTicket  = ticket;

        return item;
    }

    public boolean repairItem(){
        workerItem = null;
        return tickets.closeTicket(workerTicket);
    }


    public Item backAfterRepair(Ticket ticket){
        Item item = ticket.getItem();
        ticket.getOwner().getItems().add(item);

        return item;
    }
}
