package week3.service_centre.dao;

import com.sun.jmx.remote.internal.ClientListenerInfo;
import week3.service_centre.db.Database;
import week3.service_centre.model.Client;
import week3.service_centre.model.utilits.DataValidator;

public class ClientDao implements IClientDao {


    @Override
    public boolean create(String name, String email, String phone) {

        if(!DataValidator.checkName(name) || !DataValidator.checkEmail(email) || !DataValidator.checkPhone(phone)){
            System.out.println("user cant be created. enter valid data");
            return false;
        }

        Client client = new Client(name, email, phone);
        Database.clients.add(client);
        return true;
    }

    @Override
    public boolean updateClientById(int id, Client updatedClient) {
        if(updatedClient == null){
            System.out.println("client cant be null. Use delete method to delete client");
            return false;
        }

        String email = updatedClient.getEmail();
        Client oldClient = read(email);
        int index = Database.clients.indexOf(oldClient);
        Database.clients.set(index, updatedClient);

        return true;
    }

    @Override
    public boolean delete(String phone) {
        for (int i = 0; i < Database.clients.size(); i++) {
            if(Database.clients.get(i).getPhone().contains(phone)){
                Database.clients.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Client read(String emailOrPhone) {
        for (int i = 0; i < Database.clients.size(); i++) {
            if(Database.clients.get(i).getPhone().contains(emailOrPhone) ||
                    Database.clients.get(i).getEmail().contains(emailOrPhone)){
                return Database.clients.get(i);
            }
        }
        System.out.println("Entered value doesnt match any account from db");
        return null;
    }
}
