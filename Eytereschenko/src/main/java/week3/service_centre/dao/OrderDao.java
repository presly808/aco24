package week3.service_centre.dao;

import week3.service_centre.db.Database;
import week3.service_centre.model.Client;
import week3.service_centre.model.Order;



public class OrderDao implements IOrderDao{

    @Override
    public int createOrder(Client client){
        if(client == null){
            System.out.println("Null client");
            return -1;
        }
        Order order = new Order(client);
        Database.orders.add(order);
        return order.getOrderId();
    };

    @Override
    public Order readOrder(int id){

        for (int i = 0; i < Order.getLastOrderId() - 1; i++) {
            if(Database.orders.get(i).getOrderId() == id){
                return Database.orders.get(i);
            }
        }

        System.out.println("There is no Order with id =" + id);
        return null;
    };

    @Override
    public boolean updateOrder(Order updatedOrder){

        Order oldOrder = readOrder(updatedOrder.getOrderId());
        if(oldOrder == null) {
            return false;
        }

        int index = Database.orders.indexOf(oldOrder);
        Database.orders.set(index, updatedOrder);
        return true;
    };

    @Override
    public boolean deleteOrder(int id){

        return Database.orders.remove(readOrder(id));

    };

}
