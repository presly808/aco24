package week3.servicecenter.dao;

import week3.servicecenter.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    private final List<Item> itemList;

    public ItemDaoImpl(List<Item> itemList) {
        this.itemList = new ArrayList<>();
    }

    @Override
    public boolean create(Item item) {
        return itemList.add(item);
    }

    @Override
    public List<Item> read() {
        return itemList;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
