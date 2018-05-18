package service_center.utils;

import service_center.controller.ClientController;
import service_center.controller.ClientControllerImpl;
import service_center.controller.SpecialistController;
import service_center.controller.SpecialistControllerImpl;
import service_center.dao.ClientDao;
import service_center.dao.DbContainer;
import service_center.dao.SpecialistDao;
import service_center.dao.TicketDao;

import java.util.HashMap;
import java.util.Map;

public final class Factory {

    private static final Map<String, Object> objectMap = new HashMap<>();
    private static ClientController clientController
            = new ClientControllerImpl(new TicketDao(), new ClientDao());
    private static SpecialistController specialistController
            = new SpecialistControllerImpl(new SpecialistDao());


    static {

        objectMap.put("db", new DbContainer());
        objectMap.put("clientController", clientController);
        objectMap.put("specialistController", specialistController);

    }

    public static <T> T getItem(String name) {
        return (T) objectMap.get(name);
    }

}
