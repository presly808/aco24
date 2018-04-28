package week3.data;

import week3.model.User;
import week3.model.Ticket;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static List<User> users;
    public static List<Ticket> tickets;

    static {
        users = new ArrayList<User>();
        tickets = new ArrayList<Ticket>();
    }
}
