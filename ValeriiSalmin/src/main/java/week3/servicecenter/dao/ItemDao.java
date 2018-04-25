package week3.servicecenter.dao;

import week3.servicecenter.model.Item;

import java.util.List;

public interface ItemDao {

    public boolean create(Item item);
    public List<Item> read();
    public void update();
    public boolean delete(Item item);
}
