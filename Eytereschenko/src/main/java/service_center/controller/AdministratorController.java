package service_center.controller;

import service_center.exception.InputNullException;
import service_center.exception.ItemNotFoundException;
import service_center.exception.LoginOrPwdIncorrectException;
import service_center.model.Specialist;
import service_center.model.Status;
import service_center.model.Ticket;

import java.util.List;

public interface AdministratorController {

    boolean login(String login, String password)
            throws LoginOrPwdIncorrectException;

    List<Specialist> checkFreeSpecialists();

    boolean changeSpecialistSalary(String specialistId, Double salary) throws InputNullException;

    Specialist fireSpecialist(String specialistId) throws ItemNotFoundException, InputNullException;

    Status checkTicketStatus(String ticketId) throws InputNullException, ItemNotFoundException;

    boolean assignTicketToSpecialist(String ticketId, String specialistId) throws InputNullException, ItemNotFoundException;

    List<Ticket> allFreeTickets();

    boolean assignAllFreeTicketsToSpecialistsRandom() throws InputNullException, ItemNotFoundException;

}
