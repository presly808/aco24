package week3.servicecenter.utils;

import week3.servicecenter.controller.Controller;

public class ObjectFactory {

    public static Controller get(){
        return new Controller();
    }
}
