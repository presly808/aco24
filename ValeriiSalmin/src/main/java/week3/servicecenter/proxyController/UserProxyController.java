package week3.servicecenter.proxyController;

import week3.servicecenter.controller.UserController;
import week3.servicecenter.controller.UserControllerImpl;
import week3.servicecenter.model.Item;

public class UserProxyController implements UserController{

    private UserController userController;

    public UserProxyController(UserController userController){
        this.userController = userController;
    }

    public String checkTicketStatus(int id){
        System.out.println("vitalik proxy checkTicketStatus");
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
