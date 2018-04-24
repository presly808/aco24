package week3.servicecenter.model;

import java.util.ArrayList;
import java.util.List;

public class User extends Human{

    private List<Item> items = new ArrayList<Item>();

    public User(String name, String phone) {
        this.name = name;
        this.phoneNumber = phone;
    }

    private Item giveItem(String name, User user, Ticket ticket){
        return new Item(name,user,ticket);
    }



    private void takeItemBack(Item item){

    }

    private void leaveComment(Ticket ticket, String comment){

    }

    //(date, NUmber, name)
    private void otherFilteringActions(){

    }
}
