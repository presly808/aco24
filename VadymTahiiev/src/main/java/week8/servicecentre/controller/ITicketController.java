package week8.servicecentre.controller;

import week8.servicecentre.model.Ticket;

public interface ITicketController {
    public boolean giveItem(String name, String model, double price, String id) throws Exception;
    public boolean takeItem(String id) throws Exception;
}
