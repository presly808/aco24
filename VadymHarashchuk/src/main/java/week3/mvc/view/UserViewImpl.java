package week3.mvc.view;

import week3.mvc.controller.LoginController;
import week3.mvc.controller.ServiceFactory;
import week3.mvc.dao.TicketDao;
import week3.mvc.model.human.User;
import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

import java.util.List;
import java.util.Scanner;

public class UserViewImpl implements UserView{

    private LoginController loginController;
    private TicketDao tickets;
    private List<Item> userItems;
    private String accessKey;
    private User user;

    public UserViewImpl() {
        loginController = (LoginController) ServiceFactory.get("loginController");
        tickets = (TicketDao) ServiceFactory.get("ticketDao");

    }

    public void login() {

        System.out.println("*********************************");
        System.out.println("*You are trying to login as User*");
        System.out.println("*********************************");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        accessKey = loginController.login("user", username, password);

        if (accessKey != null) {
            System.out.println("Enter your phone number: ");
            String phone = scanner.nextLine();
            System.out.println("Enter your item's model: ");
            String model = scanner.nextLine();
            System.out.println("Enter your item's type(e.g: iron, TVset, cellphone): ");
            String type = scanner.nextLine();
            System.out.println("Enter your item's state(1 - COSMETIC_DEFECT, 2 - BAD, 3- BROKEN,  4- FIXED): ");
            int number = scanner.nextInt();
            String state;
            int hours;
            switch (number) {
                case 1:
                    state = "COSMETIC_DEFECT";
                    hours = 2;
                    break;
                case 2:
                    state = "BAD";
                    hours = 6;
                    break;
                case 3:
                    state = "BROKEN";
                    hours = 20;
                    break;
                case 4:
                    state = "FIXED";
                    hours = 0;
                    break;
                default:
                    state = "BAD";
                    hours = 6;

            }
            user = new User(username, phone,
                    new Ticket(new Item(model, type, state), hours));
            userItems = user.getItems();
            return;
        }
        try {
            throw new Exception("Credentials aren't correct");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean giveItem(Item item, int hours) {
        if (accessKey == null) {
            login();
        }
        user.getItems().remove(item);


        return tickets.createTicket(item, hours) != null;
    }

    public String checkTicketStatus(Ticket ticket) {
        if (accessKey == null) {
            login();
        }
        return tickets.getAllTickets().stream()
                .filter(ticket1 -> ticket1.equals(ticket))
                .map(Ticket::getStatus).findFirst().get();
    }

    public Item takeItemBack(Ticket ticket) {
        if (accessKey == null) {
            login();
        }

        Item item = tickets.getAllTickets().stream()
                .filter(ticket1 -> ticket1.equals(ticket))
                .map(Ticket::getItem).findFirst().get();

       user.getItems().add(item);
        return item;
    }

    public void leaveComment(String comment) {
        if (accessKey == null) {
            login();
        }
        System.out.println(comment);
    }


}
