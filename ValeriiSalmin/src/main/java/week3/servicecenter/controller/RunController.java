package week3.servicecenter.controller;

import week3.servicecenter.model.PersonDB;

public class RunController {

    public static void main(String[] args) {
        PersonDB personDB = new PersonDB();
        LoginController loginController = new LoginController(personDB);
    }
}
