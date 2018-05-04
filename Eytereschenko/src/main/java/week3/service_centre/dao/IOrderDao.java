package week3.service_centre.dao;

import week3.service_centre.model.Client;
import week3.service_centre.model.Order;

public interface IOrderDao {

    int createOrder(Client client);

    Order readOrder(int id);

    boolean updateOrder(Order updatedOrder);


    boolean deleteOrder(int id);


}
