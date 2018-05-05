package week3.data;

import week3.model.*;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static List<User> users;
    public static List<Ticket> tickets;
    public static List<Password> passwords;
    public static List<Worker> workers;

    static {
        users = new ArrayList<User>();
        tickets = new ArrayList<Ticket>();
        passwords = new ArrayList<Password>();
        workers = new ArrayList<Worker>();
    }
}
