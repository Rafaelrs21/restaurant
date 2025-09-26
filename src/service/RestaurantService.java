package service;

import entities.Menu;
import entities.Restaurant;
import repository.RestaurantRepository;
import repository.RestaurantSection;

import java.util.List;

public class RestaurantService {
    private final Restaurant restaurant;
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurant = RestaurantSection.getRestaurantLog();
    }

    public void addDish(String name, double price, String category){
        Menu menu = new Menu(name, price, category);
        restaurant.getMenu().add(menu);
    }

    public void listDish(){
        List<Menu> dishes = restaurant.getMenu();

        if(dishes.isEmpty()){
            System.out.println("O cardápio está vazio.");
            return;
        }

        System.out.println("Cardápio do restaurante " + restaurant.getName() + ":");
        for (Menu dish : dishes){
            System.out.println(dishes);
        }
    }

    public void updateDish(String name, String newName, Double price, String category){
        List<Menu> dishes = restaurant.getMenu();

        for (Menu dish : dishes){
            if(dish.getName().equalsIgnoreCase(name)){

                if(newName != null && !newName.isEmpty() ){
                    dish.setName(newName);
                }

                if(price != null && price > 0){
                    dish.setPrice(price);
                }

                if(category != null && !category.isEmpty()){
                    dish.setCategory(category);
                }
            }
            System.out.println(dishes);
        }
    }

    public void deleteDish(String name){
        List<Menu> dishes = restaurant.getMenu();

        boolean removed = dishes.removeIf(d -> d.getName().equalsIgnoreCase(name));

        if (removed){
            System.out.println("Prato removido com sucesso: " + name);
        }
        else{
            System.out.println("Prato não encontrado: " + name);
        }
    }
}
