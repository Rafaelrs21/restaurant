package repository;

import entities.Restaurant;

import java.util.HashMap;
import java.util.Map;

public class RestaurantRepository {
    private static final Map<String, Restaurant> restaurants = new HashMap<>();

    public boolean adicionarUsuario(Restaurant restaurant) {
        if (restaurants.containsKey(restaurant.getName())) {
            return false;
        } else {
            restaurants.put(restaurant.getName(), restaurant);
            return true;
        }
    }

    public Restaurant searchRestaurant(String name) {
        return restaurants.get(name);
    }

    public boolean autenticar(String name, String password){
        Restaurant restaurant = restaurants.get(name);
        return restaurant != null && restaurant.getPassword().equals(password);
    }
}
