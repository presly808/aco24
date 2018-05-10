package week3.service_centre.model.utilits;

import week3.service_centre.db.Database;
import week3.service_centre.model.Client;

public class DataValidator {

    public static boolean checkPhone(String phone){
        if(Database.clients.stream().map(Client::getPhone).anyMatch(n -> n.equals(phone))){
            System.out.println("This phone is already exist on some our client");
            return false;
        }
        return phone !=null && !phone.isEmpty() && phone.matches("[+][0-9]{12}");

    }

    public static boolean checkWorkersLogin(String login){

        if(login == null || login.isEmpty()){
            System.out.println("Login is empty or null");
            return false;
        }

        for (int i = 0; i < Database.workers.size(); i++) {
            if(Database.workers.get(i).getLogin().equals(login)){
                System.out.println("This login is already exist in db");
                return false;
            }
        }

        return true;
    }



    public static boolean checkName(String name){

        return name != null && !name.isEmpty() && name.matches("[a-zA-Z]*");

    }

    public static boolean checkSurname(String surname){

        return surname != null && !surname.isEmpty() && surname.matches("[a-zA-Z]*");

    }


    public static boolean checkEmail(String email){

        return email != null && !email.isEmpty() && email.matches("/@/");

    }

}
