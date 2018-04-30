package week3.servicecenter.controller;

import week3.servicecenter.model.PersonDB;

public class LoginController {

    PersonDB personDB;
    String name;
    String password;

    public LoginController(String name, String password) {
        this.personDB = personDB;
        this.name = name;
        this.password = password;
    }


}
