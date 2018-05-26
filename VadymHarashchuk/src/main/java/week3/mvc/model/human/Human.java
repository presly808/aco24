package week3.mvc.model.human;

import week3.mvc.model.repair.Ticket;

import java.util.List;

 public interface Human {

     String getName();

     String getPassword();

     void setPassword(String password);

     void setName(String name);

     String getPhoneNumber();

     void setPhoneNumber(String phoneNumber);

     List<Ticket> getTickets();

     void setTickets(List<Ticket> tickets);

     String getType();


    
}
