package week8.servicecentre;

import week8.servicecentre.controller.*;
import week8.servicecentre.dao.DB;

public class Start {
    public static void main(String[] args) throws Exception{
        IUserController userController = new ProxyUserController();
        boolean res1 = userController.registerUser("vadym","+3855","123qwe");
        boolean res2 = userController.registerUser("oleh","+30009","asdzxc");
        System.out.println(res1);
        System.out.println(res2);
        String res3 = userController.loginUser("vadym","123qwe");
        String res4 = userController.loginUser("oleh","asdzxc");
        System.out.println(res3);
        System.out.println(res4);

        ITicketController ticketController = new ProxyTicketController();
        boolean ress1 = ticketController.giveItem("gw","dgsg",42342.4, res3);
        boolean ress2 = ticketController.giveItem("bbbbb","aaaa",442.4,res4);
        System.out.println("ress1  " + ress1);
        System.out.println("ress2  " + ress2);
        boolean ress3 = ticketController.takeItem(res3);
        System.out.println(ress3);
        boolean ress4 = ticketController.takeItem(res4);
        System.out.println(ress4);
        for (int i = 0; i < DB.users.entrySet().toArray().length; i++) {
            System.out.println(DB.users.entrySet().toArray()[i]);
        }
    }
}
