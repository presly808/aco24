package week3.service_centre.dao;

import org.apache.xpath.operations.Or;
import week3.service_centre.model.Client;
import week3.service_centre.model.Order;

import java.util.List;

public interface IOrderDao {

    int createOrder(Client client, String product);

    Order readOrder(int id);

    boolean updateOrder(Order updatedOrder);

    boolean deleteOrder(int id);

    List<Order> showAllOrders();
}
