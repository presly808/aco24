package service_center.dao;

import service_center.model.Client;
import service_center.utils.Factory;
import service_center.utils.NumberUtils;

public class ClientDao implements Dao<Client> {

    private DbContainer container = Factory.getItem("db");

    public ClientDao() {
    }

    @Override
    public boolean create(Client client) {

        client.setId(NumberUtils.generateId());
        return container.clients.add(client);

    }

    @Override
    public Client read(String id) {

        return container.clients.stream().filter(contact -> contact.getId()
                .equals(id)).findFirst().orElse(null);

    }

    @Override
    public boolean update(Client client) {

        int indexArr = container.clients.indexOf(read(client.getId()));
        if(indexArr == -1){
            return false;
        }

        container.clients.set(indexArr, client);

        return true;
    }

    @Override
    public Client delete(String id) {

        Client client = read(id);
        if(client == null){
            return null;
        }
        container.clients.remove(client);

        return client;
    }

    @Override
    public Client[] all() {
        return container.clients.toArray(new Client[container.clients.size()]);
    }
}
