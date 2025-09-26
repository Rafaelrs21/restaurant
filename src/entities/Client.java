package entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String telephone;
    private Restaurant restaurant;

    private List<Order> myOrder = new ArrayList<>();

    public Client() {}

    public Client(String name, String telephone, Restaurant restaurant) {
        this.name = name;
        this.telephone = telephone;
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Order> getMyOrder() {
        return myOrder;
    }

    public void setMyOrder(List<Order> myOrder) {
        this.myOrder = myOrder;
    }
}
