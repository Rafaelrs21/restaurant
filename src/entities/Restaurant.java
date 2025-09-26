package entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int contador = 1;
    private Integer Id;
    private String name;
    private String password;

    private List<Menu> menu = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public Restaurant() {}

    public Restaurant(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {orders.add(order);}

    public void removeOrder(Order order) {orders.remove(order);}

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }
}
