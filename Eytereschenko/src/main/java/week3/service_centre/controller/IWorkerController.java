package week3.service_centre.controller;

import week3.service_centre.model.Ticket;

import java.util.List;

public interface IWorkerController {

    boolean fixItem(int ticketId);

    List<Ticket> showMyTickets(String login);

    

}
