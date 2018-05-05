package week2.mvc.view;

import week1.Contact;
import week2.mvc.contactController.ContactController;
import week2.mvc.contactController.ContactControllerImpl;
import week2.mvc.dataModel.DataModelImpl;

import java.util.Arrays;
import java.util.Scanner;

public class ContactView {

    private ContactController contactController = new ContactControllerImpl(new DataModelImpl());

    public void initData() throws Exception {
        contactController.addContact(new Contact(1, "Ivan", "+380932312345"));
        contactController.addContact(new Contact(2, "Igor", "+380932312346"));
        contactController.addContact(new Contact(3, "Oleg", "+380932312347"));
    }

    public void runController(){
        System.out.println("What you wonna do?");
        System.out.println("1. Add contact");
        System.out.println("2. Find contact");
        System.out.println("3. Get all contacts");
        System.out.println("4. Remove contact");
        System.out.println("Please put your number");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        if (value==1){
            System.out.println("Specify data of your contact");
            System.out.println("Id = ");
            int id = scanner.nextInt();
            System.out.println("You enter " + id);
            System.out.println("Name = ");
            String name = scanner.next();
            System.out.println("You enter " + name);
            System.out.println("Number = ");
            String number = scanner.next();
            System.out.println("You enter " + number);

            try {
                contactController.addContact(new Contact(id,name,number));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (value==2){
            System.out.println("Specify number or name");
            String number = scanner.next();
            System.out.println("Your enter " + number);
            try {
                Arrays.asList(contactController.findByNameOrNumber(number)).forEach(contact -> contact.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (value==3){
            Arrays.asList(contactController.getAll()).forEach(contact -> contact.toString(contact));
        }

        if (value==4){
            System.out.println("Specify data of your contact");
            System.out.println("Id = ");
            int id = scanner.nextInt();
            System.out.println("Your enter " + id);
            try {
                contactController.removeContact(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
