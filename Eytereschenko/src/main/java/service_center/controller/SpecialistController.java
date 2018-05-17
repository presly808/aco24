package service_center.controller;

import service_center.model.Ticket;

import java.util.List;

public interface SpecialistController {

    boolean login(String login, String password);
    boolean createNewAccount(String name, String login, String password);
    boolean repairItem();
    List<Ticket> seeMyTicketList();


}
