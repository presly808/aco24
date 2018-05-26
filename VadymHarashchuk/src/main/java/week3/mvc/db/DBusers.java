package week3.mvc.db;

import com.google.gson.Gson;
import week3.mvc.controller.ServiceFactory;
import week3.mvc.exceptions.RegisterException;
import week3.mvc.model.human.User;
import week3.mvc.model.human.Worker;
import week3.mvc.model.repair.Item;
import week3.mvc.model.repair.Ticket;
import week3.mvc.server.Server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBusers {

    private Gson gson;
    private BufferedReader reader;
    private FileWriter writer;


    public DBusers() {
        gson = (Gson) ServiceFactory.getBean("gson");
        try {
            // reader = new BufferedReader(new FileReader(String.valueOf(Server.class.getResource("/week3/mvc/resources/") + "users.txt")));
            reader = new BufferedReader(new FileReader("users.txt"));
            writer = new FileWriter(new File("users.txt"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<User> findUsers(String key) {
        List<User> users = new ArrayList<>();
        try {
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                if (line.contains(key)) {
                    users.add(gson.fromJson(line, User.class));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }


    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                list.add(gson.fromJson(line, User.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
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
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            while (reader.ready()){
                String s = reader.readLine();
                if (s.contains("name\":\"" + user.getName()))
                    throw new RegisterException("User with such name is exists!");

            }
        } catch (RegisterException | IOException e) {
            e.printStackTrace();
            return false;
        }
        try(FileWriter writer = new FileWriter(new File("users.txt"), true)) {
            writer.write("\n" + userJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
