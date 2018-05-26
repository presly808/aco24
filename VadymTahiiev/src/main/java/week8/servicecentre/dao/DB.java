package week8.servicecentre.dao;

import week8.servicecentre.model.Ticket;
import week8.servicecentre.model.User;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DB {
    public static Map<User, Ticket> users;

    static {
        users = new HashMap<User, Ticket>();
    }
}
