package week3.service_centre.controller;

import week3.service_centre.model.*;

import java.util.List;

public interface IAdminController {

    boolean loginInto(String login, String password);

    boolean hireWorker(String name, int age, String login, String password, double salary);

    Ticket createTicketFromOrder(Order order) throws Exception;

    boolean fireWorker(int id);

    List<Order> seeAllOrdersInSomeStatus(Status status);

    List<Ticket> seeAllTicketsInSomeStatus(Status status);
}
