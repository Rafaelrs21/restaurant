package repository;

import entities.Client;
import entities.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private final List<Client> clients = new ArrayList<>();

    public boolean addClient(Client client) {
        if (searchClient(client.getName(), client.getRestaurant()) != null) {
            return false;
        }
        clients.add(client);
        return true;
    }

    public Client searchClient(String name, Restaurant restaurant) {
        return clients.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name)
                        && c.getRestaurant().equals(restaurant))
                .findFirst()
                .orElse(null);
    }

    public List<Client> listClientsByRestaurant(Restaurant restaurant) {
        return clients.stream()
                .filter(c -> c.getRestaurant().equals(restaurant))
                .toList();
    }
}

