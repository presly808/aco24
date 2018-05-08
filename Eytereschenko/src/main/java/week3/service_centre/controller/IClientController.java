package week3.service_centre.controller;

import week3.service_centre.model.*;

import javax.security.auth.login.LoginException;

public interface IClientController {

    boolean loginInto(String email, String phone) throws LoginException;

    Status checkOrderStatus(int id);

    int giveItemToRepair(String product);

    boolean getProductBackForce(int id);

}
