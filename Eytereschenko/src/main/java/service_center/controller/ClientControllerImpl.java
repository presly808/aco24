package service_center.controller;

import service_center.dao.Dao;
import service_center.dao.DbContainer;
import service_center.exception.InputNullException;
import service_center.exception.LoginAlreadyExistException;
import service_center.exception.LoginOrPwdIncorrectException;
import service_center.exception.TicketNotFoundException;
import service_center.model.Client;
import service_center.model.Product;
import service_center.model.Status;
import service_center.model.Ticket;
import service_center.utils.Factory;

import javax.security.auth.login.LoginException;
import java.util.Date;

public class ClientControllerImpl implements ClientController {

    private Dao<Ticket> ticketDao;
    private Dao<Client> clientDao;
    DbContainer container = Factory.getItem("db");


    public ClientControllerImpl(Dao<Ticket> ticketDao, Dao<Client> clientDao) {
        this.ticketDao = ticketDao;
        this.clientDao = clientDao;
    }

    @Override
    public boolean createNewAccount(String name, String login, String password)
            throws LoginAlreadyExistException {

        Client isExist = container.clients.stream().
                filter(n -> n.getLogin().equals(login)).
                findFirst().orElse(null);

        if(isExist != null){
            throw new LoginAlreadyExistException("This login is already used by another user");
        }

        Client newClientAccount = new Client(name);
        newClientAccount.setLogin(login);
        newClientAccount.setPassword(password);
        return clientDao.create(newClientAccount);

    }

    @Override
    public boolean login(String login, String password) throws LoginOrPwdIncorrectException {

        Client isCorrectLoginPwd = container.clients.stream().filter(n ->
                (n.getLogin().equals(login))
                        && n.getPassword().equals(password)).
                findFirst().orElse(null);

        if(isCorrectLoginPwd == null){
            throw new LoginOrPwdIncorrectException("Your login or password incorrect");
        }

        return false;
    }

    @Override
    public Ticket createTicket(Product product) throws InputNullException {

        if(product == null){
            throw new InputNullException("product cant be empty!");
        }
        Ticket ticket = new Ticket(product);
        container.tickets.add(ticket);
        return ticket;
    }

    @Override
    public Status checkTicketStatus(String ticketId) throws TicketNotFoundException {
        Ticket ticket = ticketDao.read(ticketId);
        if(ticket == null){
            throw new TicketNotFoundException("There is no ticket with ticketId = " + ticketId);
        }
        return ticket.getStatus();
    }

    @Override
    public int countDaysInProgress(String ticketId) throws TicketNotFoundException {

        Date currentDate = new Date();
        Ticket ticket = ticketDao.read(ticketId);
        if(ticket == null){
            throw new TicketNotFoundException("There is no ticket with ticketId = " + ticketId);
        }

        return (int) (currentDate.getTime() - ticket.getCreateDate().getTime())
                / (24 * 60 * 60 * 1000);
    }
}
