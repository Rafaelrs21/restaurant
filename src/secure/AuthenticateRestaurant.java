package secure;

import entities.Restaurant;
import repository.RestaurantRepository;
import repository.RestaurantSection;

import java.util.Scanner;

public class AuthenticateRestaurant {
    private final RestaurantRepository repository;

    public AuthenticateRestaurant(RestaurantRepository repository) {
        this.repository = repository;
    }

    public RestaurantRepository getRepository() {
        return repository;
    }

    public Restaurant registerRestaurant(String name, String password) {
        if (repository.searchRestaurant(name) != null) {
            System.out.println("Username already exists. Please choose another.");
            return null;
        }

        Restaurant restaurant = new Restaurant(name, password);
        repository.adicionarUsuario(restaurant);

        System.out.println("Registration successful! " + restaurant);
        return restaurant;
    }

    public Restaurant logRestaurant(String name, String password) {
        if (repository.autenticar(name, password)) {
            Restaurant restaurant = repository.searchRestaurant(name);
            RestaurantSection.setRestaurantLog(restaurant);
            System.out.println("Login successful! Welcome, " + restaurant.getName() + ".");
            return restaurant;
        } else {
            System.out.println("Invalid restaurant or password.");
            return null;
        }
    }

}

