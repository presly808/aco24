package week2.Manager;

import java.util.*;

/**
 * You can add any additional classes to make structure more flexible and scalable
 */
public class Manager {
    private String name;
    private int salary;
    public List<Employee> employees;


    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
        employees = new ArrayList<Employee>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // manager has fixed salary + 5% from each employee that subordinate to manager
    public int calculateSalary(){
        int addSalary = 0;
        for (int i = 0; i < employees.size(); i++) {
            addSalary += (int)(employees.get(i).getSalary() * 0.05);
        }
        return this.getSalary() + addSalary;
    }

    public boolean addSubworker(Employee employee){
        if (employee == null) return false;
        if (employee.getClass() != Employee.class) return false;
        employees.add(employee);
        return true;
    }

    public List<Employee> getSubworkers(){
        return employees;
    }
}
