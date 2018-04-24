package week2.mvc.model;

public class ContactValidator {

    public static boolean validate(Contact contact){

        if(contact.getName() == null || contact.getName().isEmpty()){
            System.out.println("Name is empty or null");
            return false;
        }

        if(!contact.getName().matches("[a-zA-Z]*")){
            System.out.println("Name should contains only letters");
            return false;
        }

        if(contact.getNumber() == null || contact.getNumber().isEmpty()){
            System.out.println("Number is empty or null");
            return false;
        }

        if(!contact.getNumber().matches("[+][0-9]{12}")){
            System.out.println("Number doesn't match international pattern");
            return false;
        }

        return true;
    }


}
