package week3.mvc.controller;

import week3.mvc.model.human.Worker;
import week3.mvc.view.AdminView;
import week3.mvc.view.UserView;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogActionsProxy implements InvocationHandler {

    private Object originalObject;


    LogActionsProxy(Object originalObject) {
        this.originalObject = originalObject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> list = new ArrayList<>();
        if (args != null) {
            list = Arrays.asList(args);
        }

        FileWriter file = new FileWriter(new File("sys.log"), true);

        if (method.getName().contains("login")) {
            file.write(originalObject.getClass().getSimpleName().replace("ViewImpl", "") + " was logged to view at " + LocalDate.now()
                    + " " + LocalTime.now() + "\n");
        } else if (method.getName().contains("Worker")) {
            Worker w = (Worker) list.get(0);
            file.write(method.getName() + " method was invoked by admin at " +
                    LocalDate.now() + " " + LocalTime.now() + " with such args: "
                    + w.getName() + "," + w.getPhoneNumber() + "," + w.getSalary() + "\n");
        } else {
            file.write(method.getName() + " method was invoked by "
                    + originalObject.getClass().getSimpleName().replace("ViewImpl", "")
                    + " at " +
                    LocalDate.now() + " " + LocalTime.now() + "\n");

        }

        file.close();

        return method.invoke(originalObject, args);
    }
}
