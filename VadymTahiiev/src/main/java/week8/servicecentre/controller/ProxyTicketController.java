package week8.servicecentre.controller;

import week8.servicecentre.model.Ticket;

public class ProxyTicketController implements ITicketController {
    private TicketController ticketController;

    public ProxyTicketController() {
        ticketController = new TicketController();
    }

    @Override
    public boolean giveItem(String name, String model, double price, String id) throws Exception {
        if (name.isEmpty()) {
            return false;
        }
        if (model.isEmpty()) {
            return false;
        }
        if (price == 0.0) {
            return false;
        }

        return ticketController.giveItem(name, model, price, id);
    }

    @Override
    public boolean takeItem(String id) throws Exception {
        return ticketController.takeItem(id);
    }
}
