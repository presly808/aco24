package service_center.dao;

import service_center.model.Client;
import service_center.model.Specialist;
import service_center.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class DbContainer {

    public List<Client> clients = new ArrayList<>();
    public List<Ticket> tickets = new ArrayList<>();
    public List<Specialist> specialists = new ArrayList<>();

}
