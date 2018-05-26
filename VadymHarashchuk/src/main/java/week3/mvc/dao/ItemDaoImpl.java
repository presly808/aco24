package week3.mvc.dao;

import week3.mvc.controller.ServiceFactory;
import week3.mvc.db.DataBase;
import week3.mvc.model.repair.Item;

public class ItemDaoImpl implements ItemDao {

    DataBase database;

    public ItemDaoImpl() {

        database = (DataBase) ServiceFactory.getBean("database");
    }

    public Item getItem(String model) {

        return database.getItems().stream()
                .filter(item -> item.getModel().equals(model))
                .findFirst().get();
    }


    public Item getItem(Item item) {
        return null;
    }

    public boolean setItemStatus(Item item, String status) {
        return false;
    }


    public boolean isItemFixed(Item item) {
        return false;
    }
}
