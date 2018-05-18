package service_center.controller;

import service_center.dao.Dao;
import service_center.dao.DbContainer;
import service_center.exception.InputNullException;
import service_center.exception.ItemNotFoundException;
import service_center.exception.LoginOrPwdIncorrectException;
import service_center.exception.NullTicketIdException;
import service_center.model.Specialist;
import service_center.model.Status;
import service_center.model.Ticket;
import service_center.utils.Factory;

import java.util.List;
import java.util.stream.Collectors;

public class AdministratorControllerImpl implements AdministratorController {

    private Dao<Specialist> specialistDao;
    private Dao<Ticket> ticketDao;
    private DbContainer container = Factory.getItem("db");

    @Override
    public boolean login(String login, String password) throws LoginOrPwdIncorrectException {

        if(!"admin".equals(login) || "admin".equals(password)){
            throw new LoginOrPwdIncorrectException("incorrect login or password");
        }

        return true;

    }

    @Override
    public List<Specialist> checkFreeSpecialists() {

        return container.specialists.stream().
                filter(n -> n.getTicketList().size() == 0).
                collect(Collectors.toList());

    }

    @Override
    public boolean changeSpecialistSalary(String specialistId, Double salary)
            throws InputNullException {

        if(specialistId == null || salary == null){
            throw new InputNullException("SpecialistId or salary cant be null");
        }

        Specialist specialist = specialistDao.read(specialistId);
        specialist.setSalary(salary);

        return true;

    }

    @Override
    public Specialist fireSpecialist(String specialistId)
            throws ItemNotFoundException, InputNullException {

        if(specialistId == null){
            throw new InputNullException("input not null value");
        } else if(specialistDao.read(specialistId) == null){
            throw new ItemNotFoundException("there is no specialist with such id = " + specialistId);
        }

        return specialistDao.delete(specialistId);

    }

    @Override
    public Status checkTicketStatus(String ticketId) throws InputNullException, ItemNotFoundException {

        if(ticketId == null){
            throw new InputNullException("input not Null ticketId");
        }

        Ticket ticket = ticketDao.read(ticketId);
        if(ticket == null){
            throw new ItemNotFoundException("there is no ticket with ticketId = " + ticketId);
        }

        return ticket.getStatus();

    }

    @Override
    public boolean assignTicketToSpecialist(String ticketId, String specialistId)
            throws InputNullException, ItemNotFoundException {

        if(ticketId == null || specialistId == null){
            throw new InputNullException("input not null values");
        }

        Ticket ticket = ticketDao.read(ticketId);
        Specialist specialist = specialistDao.read(specialistId);

        if(ticket == null){
            throw new ItemNotFoundException("ticket cant be found");
        } else if(specialist == null){
            throw new ItemNotFoundException("specialist cant be found");
        }

        ticket.setSpecialist(specialist);
        return specialist.getTicketList().add(ticket);

    }

    @Override
    public List<Ticket> allFreeTickets() {

        return container.tickets.stream().filter(n -> n.getSpecialist() == null)
                .collect(Collectors.toList());

    }

    @Override
    public boolean assignAllFreeTicketsToSpecialistsRandom()
            throws InputNullException, ItemNotFoundException {

        List<Ticket> ticketList = allFreeTickets();

        for (Ticket t :
                ticketList) {
            Specialist specialist = findSpecToAssign();
            if(specialist == null){
                return false;
            }
            assignTicketToSpecialist(t.getId(), specialist.getId());
        }

        return true;
    }

    private Specialist findSpecToAssign() {

        return container.specialists.
                stream().
                reduce((n1, n2) -> n1.getTicketList().size() > n2.getTicketList().size() ? n1 : n2).
                orElse(null);

    }
}
