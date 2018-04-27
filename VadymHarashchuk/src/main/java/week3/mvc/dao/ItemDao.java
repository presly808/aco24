package week3.mvc.dao;

import week3.mvc.model.repair.Item;

public interface ItemDao {

    Item getItem(String model);

    boolean setItemStatus(Item item, String status);

    boolean isItemFixed(Item item);

}
