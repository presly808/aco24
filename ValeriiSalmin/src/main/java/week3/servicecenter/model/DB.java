package week3.servicecenter.model;

import week3.servicecenter.utils.ActionLog;

import java.util.ArrayList;
import java.util.List;

public class DB {

    private List<Ticket> ticketList = new ArrayList<>();
    private List<Ticket> itemList = new ArrayList<>();
    private List<Ticket> userList = new ArrayList<>();
    private List<Ticket> workerList = new ArrayList<>();
    private List<ActionLog> log = new ArrayList<>();
}
