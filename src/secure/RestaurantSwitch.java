package secure;

import entities.Restaurant;
import options.MainMenuSwitch;
import repository.ClientRepository;

import java.util.Scanner;

public class RestaurantSwitch {
    private final AuthenticateRestaurant authenticateRestaurant;

    public RestaurantSwitch(AuthenticateRestaurant authenticateRestaurant) {
        this.authenticateRestaurant = authenticateRestaurant;
    }

    public void executeMenuLogin() {
        Scanner insert = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU RESTAURANTE ---");
            System.out.println("1. Registrar Restaurante");
            System.out.println("2. Login Restaurante");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = insert.nextInt();
            insert.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Enter desired username: ");
                    String username = insert.nextLine();
                    System.out.print("Enter password: ");
                    String password = insert.nextLine();

                    authenticateRestaurant.registerRestaurant(username, password);
                }
                case 2 -> {
                    System.out.print("Enter username: ");
                    String username = insert.nextLine();
                    System.out.print("Enter password: ");
                    String password = insert.nextLine();

                    Restaurant loggedRestaurant = authenticateRestaurant.logRestaurant(username, password);

                    if (loggedRestaurant != null) {
                        MainMenuSwitch mainMenu = new MainMenuSwitch(loggedRestaurant);
                        mainMenu.executeMainMenu();
                    } else {
                        System.out.println("Login failed. Try again.");
                    }
                }
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }
}

