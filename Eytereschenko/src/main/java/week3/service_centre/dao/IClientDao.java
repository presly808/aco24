package week3.service_centre.dao;

import week3.service_centre.model.Client;

public interface IClientDao {

    boolean create(String name, String email, String phone);

    boolean updateClientById(int id, Client updatedClient);

    boolean delete(String phone);

    Client read(String emailOrPhone);

}
