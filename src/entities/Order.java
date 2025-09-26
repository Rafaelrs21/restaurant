package entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter = 1;

    private int id;
    private boolean closed;

    private Client client;
    private List<Menu> items = new ArrayList<>();

    public Order(Client client) {
        this.id = counter++;
        this.client = client;
        this.closed = false;
    }

    public int getId() {
        return id;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Client getClient() {
        return client;
    }

    public List<Menu> getItems() {
        return items;
    }

    public void addItem(Menu menu) {
        items.add(menu);
    }

    public void removeItem(String name) {
        items.removeIf(m -> m.getName().equalsIgnoreCase(name));
    }

    public double getTotal() {
        return items.stream().mapToDouble(Menu::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Order #" + id +
                " | Client: " + client.getName() +
                " | Items: " + items +
                " | Total: $" + getTotal() +
                " | Closed: " + closed;
    }
}
