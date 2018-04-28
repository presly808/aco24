package week3.data;

import week3.model.Ticket;
import java.util.List;

public class TicketDao {

    public static boolean createTicket(Ticket ticket) {
        DataBase.tickets.add(ticket);
        return true;
    }

    public static List<Ticket> readTickets() {
        if (DataBase.tickets == null) {
            return null;
        }
        return DataBase.tickets;
    }

    public static boolean updateTicket(Ticket ticket, Ticket newTicket) {
        if (ticket == null || newTicket == null) return false;
        for (int i = 0; i < DataBase.users.size(); i++) {
            if (DataBase.tickets.get(i).equals(ticket)) {
                ticket = newTicket;
                return true;
            }
        }
        return false;
    }
}
