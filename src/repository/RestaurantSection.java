package repository;

import entities.Restaurant;

public class RestaurantSection {
    private static Restaurant restaurantLog;

    public static void setRestaurantLog(Restaurant restaurant){
        RestaurantSection.restaurantLog = restaurant;
    }

    public static Restaurant getRestaurantLog(){
        return restaurantLog;
    }

    public static void cleanSection(){
        restaurantLog = null;
    }
}
