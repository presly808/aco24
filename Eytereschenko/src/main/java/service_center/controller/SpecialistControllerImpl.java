package service_center.controller;

import service_center.dao.Dao;
import service_center.dao.DbContainer;
import service_center.exception.ItemNotFoundException;
import service_center.exception.LoginAlreadyExistException;
import service_center.exception.LoginOrPwdIncorrectException;
import service_center.exception.NullTicketIdException;
import service_center.model.Specialist;
import service_center.model.Status;
import service_center.model.Ticket;
import service_center.utils.Factory;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SpecialistControllerImpl implements SpecialistController {

    private Dao<Specialist> specialistDao;
    private DbContainer container = Factory.getItem("db");

    public SpecialistControllerImpl(Dao<Specialist> specialistDao) {
        this.specialistDao = specialistDao;
    }

    @Override
    public boolean login(String login, String password) throws LoginOrPwdIncorrectException {

        Specialist isCorrectLoginPwd = container.specialists.stream().filter(n ->
                (n.getLogin().equals(login))
                        && n.getPassword().equals(password)).
                findFirst().orElse(null);

        if(isCorrectLoginPwd == null){
            throw new LoginOrPwdIncorrectException("Your login or password incorrect");
        }

        return true;

    }

    @Override
    public boolean createNewAccount(String name, String login, String password)
            throws LoginAlreadyExistException {

        Specialist isExist = container.specialists.stream().
                filter(n -> n.getLogin().equals(login)).
                findFirst().orElse(null);

        if(isExist != null){
            throw new LoginAlreadyExistException("This login is already used by another user");
        }

        Specialist newSpecialistAccount = new Specialist(name);
        newSpecialistAccount.setLogin(login);
        newSpecialistAccount.setPassword(password);

        return specialistDao.create(newSpecialistAccount);

    }

    @Override
    public boolean repairItem(String ticketId) throws ItemNotFoundException, NullTicketIdException {

        if(ticketId == null){
            throw new NullTicketIdException("Incorrect id");
        }

        Ticket ticket = container.tickets.stream().filter(
                n -> ticketId.equals(n.getId())).findFirst().orElse(null);

        if(ticket == null){
            throw new ItemNotFoundException("Incorrect id");
        }

        ticket.setStatus(Status.DONE);
        ticket.setFinishDate(new Date());

        return true;

    }

    @Override
    public List<Ticket> seeMyTicketList(String specialistId) {

        return container.tickets.stream().
                filter(
                        n ->
                        specialistId.equals(n.getSpecialist() == null ? null
                                : n.getSpecialist().getId())
                        )
                .collect(Collectors.toList());

    }

}
