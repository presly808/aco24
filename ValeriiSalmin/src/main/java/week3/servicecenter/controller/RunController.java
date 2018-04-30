package week3.servicecenter.controller;

import week3.servicecenter.model.PersonDB;

import java.util.Scanner;

public class RunController {

    public static void main(String[] args) {
        //PersonDB personDB = new PersonDB();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();

        LoginController loginController = new LoginController(name,password);
    }
}
