package service_center.controller;

import service_center.exception.InputNullException;
import service_center.exception.LoginAlreadyExistException;
import service_center.exception.LoginOrPwdIncorrectException;
import service_center.exception.TicketNotFoundException;
import service_center.model.Product;
import service_center.model.Status;
import service_center.model.Ticket;

public interface ClientController {

    boolean createNewAccount(String name, String login, String password)
            throws LoginAlreadyExistException;

    boolean login(String login, String password)
            throws LoginOrPwdIncorrectException;

    Ticket createTicket(Product product)
            throws InputNullException;

    Status checkTicketStatus(String ticketId)
            throws TicketNotFoundException;

    int countDaysInProgress(String ticketId)
            throws TicketNotFoundException;

}
