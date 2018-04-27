package week3.mvc.controller;

import week3.mvc.view.AdminView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalTime;

public class LogActionsProxy implements InvocationHandler {

    private AdminView originalObject;

    LogActionsProxy(AdminView originalObject)
    {
        this.originalObject = originalObject;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        if (method.getName().equals("login"))
        {
            System.out.printf("LOG: Admin was logged into the system at %s",
                    LocalTime.now());
        }

        return method.invoke(originalObject, args);
    }
}
