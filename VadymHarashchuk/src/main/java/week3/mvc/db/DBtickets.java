package week3.mvc.db;

import com.google.gson.Gson;
import week3.mvc.model.human.User;
import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBtickets {

    Gson gson;
    BufferedReader reader;
    FileWriter writer;

    private List<User> users;
    private List<Worker> workers;
    private List<Ticket> tickets;
    private List<Item> items;


    public DBtickets() {
        gson = new Gson();
        try {
            reader = new BufferedReader(new FileReader("database.txt"));
            writer = new FileWriter(new File("database.txt"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }


        users = new ArrayList<>();
        workers = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public List<User> findUsers(String key){
        List<User> users = new ArrayList<>();
        try {
            String line;
            while (reader.ready()){
                line = reader.readLine();
                if (line.contains(key)){
                    users.add(gson.fromJson(line, User.class));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }


    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try  {
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                list.add(gson.fromJson(line, User.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    public boolean addUsers(List<User> users) {
        for (User user : users) {
            String userJson = gson.toJson(user);
            try {
                writer.write(userJson + "\n");
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean addUser(User user) {
        String userJson = gson.toJson(user);
        try (FileWriter writer = new FileWriter(new File("database.txt"), true)) {
            writer.write(userJson + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
