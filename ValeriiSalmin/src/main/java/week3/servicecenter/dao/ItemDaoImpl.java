package week3.servicecenter.dao;

import week3.servicecenter.model.DB;
import week3.servicecenter.model.Item;
import week3.servicecenter.utils.ObjectFactory;

import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    private DB db;

    public ItemDaoImpl() {
        db = (DB) ObjectFactory.get("DB");
    }

    @Override
    public boolean create(Item item) {
        return db.getItemList().add(item);
    }

    @Override
    public List<Item> read() {
        return db.getItemList();
    }

    @Override
    public void update() {

    }

    @Override
    public boolean delete(Item item) {
        return db.getItemList().remove(item);
    }
}
