package service_center.controller;

import service_center.exception.ItemNotFoundException;
import service_center.exception.LoginAlreadyExistException;
import service_center.exception.LoginOrPwdIncorrectException;
import service_center.exception.NullTicketIdException;
import service_center.model.Ticket;

import java.util.List;

public interface SpecialistController {

    boolean login(String login, String password)
            throws LoginOrPwdIncorrectException;
    boolean createNewAccount(String name, String login, String password)
            throws LoginAlreadyExistException;
    boolean repairItem(String ticketId) throws ItemNotFoundException, NullTicketIdException;
    List<Ticket> seeMyTicketList(String specialistId);


}
