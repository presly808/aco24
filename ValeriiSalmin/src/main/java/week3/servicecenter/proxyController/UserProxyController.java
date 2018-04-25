package week3.servicecenter.proxyController;

import week3.servicecenter.controller.Listener;
import week3.servicecenter.controller.UserController;
import week3.servicecenter.model.Item;

import java.awt.*;

public class UserProxyController implements UserController, Listener {

    private UserController userController;

    @Override
    public void listen(Event event) {

    }

    public UserProxyController(UserController userController){
        this.userController = userController;
    }

    public String checkTicketStatus(int id){
        //listener(userController.checkTicketStatus(id));
        return userController.checkTicketStatus(id);
    }

    public boolean giveItem(Item item){
        System.out.println("vitalik proxy giveItem");
        return userController.giveItem(item);
    }

    public boolean takeItemBack(Item item){
        System.out.println("vitalik proxy takeItemBack");
        return userController.takeItemBack(item);
    }

    public boolean leaveComment(int id, String comment){
        System.out.println("vitalik proxy leaveComment");
        return userController.leaveComment(id, comment);
    }

}
