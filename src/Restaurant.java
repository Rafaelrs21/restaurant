import repository.RestaurantRepository;
import secure.AuthenticateRestaurant;
import secure.RestaurantSwitch;

public class Restaurant {
    public static void main(String[] args) {
        RestaurantRepository restaurantRepo = new RestaurantRepository();

        AuthenticateRestaurant autenticaRestaurant = new AuthenticateRestaurant(restaurantRepo);

        RestaurantSwitch menu = new RestaurantSwitch(autenticaRestaurant);
        menu.executeMenuLogin();
    }
}