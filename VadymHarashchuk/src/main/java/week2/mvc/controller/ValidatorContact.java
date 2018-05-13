package week2.mvc.controller;


import week2.mvc.model.Contact;

public class ValidatorContact {

    private static final String INVALID_CHARACTERS = "?!@#$%^&*~`.,<>/\\|";
    private static final String IS_ALPHA = "[a-zA-Z]*";

    public static boolean validateContact(Contact contact) {
        if (contact == null
                || contact.getName() == null
                || contact.getNumber() == null
                || contact.getName().isEmpty()
                || contact.getNumber().isEmpty()) {
            return false;
        }

        if (contact.getNumber().matches(IS_ALPHA)
                || contact.getNumber().contains(INVALID_CHARACTERS)
                || contact.getNumber().length() < 10) {
            return false;
        }
        return true;
    }

}
