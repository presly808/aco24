package week3.data;

import week3.model.Ticket;

public class TicketDao {

    public static Ticket createTicket(Ticket ticket) {
        if (ticket == null) return null;
        DataBase.tickets.add(ticket);
        int index = DataBase.tickets.indexOf(ticket);
        return DataBase.tickets.get(index);
    }

    public static Ticket readTicket(int id) {
        if (id <= 0) return null;
        for (int i = 0; i < DataBase.tickets.size(); i++) {
            if (DataBase.tickets.get(i).getId() == id) return DataBase.tickets.get(i);
        }
        return null;
    }

    public static String updateTicket(Ticket updatedTicket) {
        if (updatedTicket == null || updatedTicket.getId() <=0 ) return null;
        for (int i = 0; i < DataBase.tickets.size(); i++) {
            if (DataBase.tickets.get(i).getId() == updatedTicket.getId()) {
                DataBase.tickets.get(i).setProductName(updatedTicket.getProductName());
                DataBase.tickets.get(i).setProductModel(updatedTicket.getProductModel());
                DataBase.tickets.get(i).setProductPrice(updatedTicket.getProductPrice());
                DataBase.tickets.get(i).setRepairingPrice(updatedTicket.getRepairingPrice());
                DataBase.tickets.get(i).setNotes(updatedTicket.getNotes());
                DataBase.tickets.get(i).setStatus(updatedTicket.isStatus());
                DataBase.tickets.get(i).setId(updatedTicket.getId());
                return DataBase.tickets.get(i).getNotes();
            }
        }
        return null;
    }

    public static Ticket deleteTicket(Ticket ticket) {
        if (ticket == null) return null;
        for (int i = 0; i < DataBase.tickets.size(); i++) {
            if (DataBase.tickets.get(i).equals(ticket)) {
                return DataBase.tickets.remove(i);
            }
        }
        return null;
    }
}
