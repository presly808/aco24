package week3.service_centre.controller;

import week3.service_centre.model.Ticket;

import javax.security.auth.login.LoginException;
import java.util.List;

public interface IWorkerController {

    boolean loginInto(String login, String password) throws LoginException;

    boolean fixItem(int ticketId);

}
