package week3.servicecenter.controller;

import week3.servicecenter.model.PersonDB;

public class LoginController {

    PersonDB personDB;

    public LoginController(PersonDB personDB) {
        this.personDB = personDB;
    }
}
