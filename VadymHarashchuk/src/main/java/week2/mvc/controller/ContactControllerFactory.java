package week2.mvc.controller;

import week2.mvc.model.DataModelImpl;

public class ContactControllerFactory {

    public static ContactControllerProxy getContactController(){

        return new ContactControllerProxy(new ContactControllerImpl(new DataModelImpl()), "Vadym", "123456");
    }
}