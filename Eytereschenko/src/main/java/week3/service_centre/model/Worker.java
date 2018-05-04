package week3.service_centre.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Worker {

    private int id;
    private String name;
    private int age;
    private String login;
    private String password;
    private double salary;
    private static int lastWorkerId;
    private ArrayList<Ticket> workerTickets;


    public Worker(String name, int age, String login, String password, double salary) {
        this.id = lastWorkerId++;
        this.name = name;
        this.age = age;
        this.login = login;
        this.password = password;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Ticket> getWorkerTickets() {
        return workerTickets;
    }

    public void setWorkerTickets(ArrayList<Ticket> workerTickets) {
        this.workerTickets = workerTickets;
    }

    public static int getLastWorkerId() {
        return lastWorkerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
