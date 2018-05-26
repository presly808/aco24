package week3.mvc.view;

import week3.mvc.exceptions.LoginException;
import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

public interface UserView {

    void login() throws LoginException;

    boolean giveItem(Item item, int hours);

    String checkTicketStatus(Ticket ticket);

    Item takeItemBack(Ticket ticket);

    void leaveComment(String comment);
}
