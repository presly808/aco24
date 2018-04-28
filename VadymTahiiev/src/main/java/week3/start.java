package week3;

import week3.Views.ProxyUserView;
import week3.Views.RealUserView;
import week3.Views.UserView;
import week3.controller.UserController;
import week3.model.Ticket;
import week3.model.User;

public class start {
    public static void main(String[] args) {
        UserView userView = new ProxyUserView();
        userView.createUser();
        userView.toControlUser();
    }
}
