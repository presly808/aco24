package week3.service_centre.controller;

import week3.service_centre.model.*;

import java.util.List;

public interface IAdminController {

    boolean hireWorker(String name, int age, String login, String password, double salary);

    Ticket createTicketFromOrder(Order order);

    boolean fireWorker(int id);

    List<Order> seeAllOrdersInSomeStatus(Status status);

    List<Ticket> seeAllTicketsInSomeStatus(Status status);
}
