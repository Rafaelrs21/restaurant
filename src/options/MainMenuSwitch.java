package options;

import entities.Client;
import entities.Menu;
import entities.Order;
import entities.Restaurant;
import repository.RestaurantRepository;
import repository.RestaurantSection;
import service.RestaurantService;

import java.util.Scanner;

public class MainMenuSwitch {
    private final Restaurant restaurant;

    public MainMenuSwitch(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void executeMainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- RESTAURANT MENU: " + restaurant.getName() + " ---");
            System.out.println("1. Add dish");
            System.out.println("2. List dishes");
            System.out.println("3. Update dish");
            System.out.println("4. Delete dish");
            System.out.println("5. Register client");
            System.out.println("6. List clients");
            System.out.println("7. Place order");
            System.out.println("8. Update order");
            System.out.println("9. List orders");
            System.out.println("10. Delete order");
            System.out.println("11. Exit");
            System.out.print("Option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Dish name: ");
                    String name = scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    restaurant.getMenu().add(new Menu(name, price, category));
                    System.out.println("Dish added successfully!");
                }
                case 2 -> {
                    if (restaurant.getMenu().isEmpty()) {
                        System.out.println("No dishes registered.");
                    } else {
                        restaurant.getMenu().forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("Enter the name of the dish to update: ");
                    String oldName = scanner.nextLine();

                    Menu dish = restaurant.getMenu().stream()
                            .filter(m -> m.getName().equalsIgnoreCase(oldName))
                            .findFirst()
                            .orElse(null);

                    if (dish == null) {
                        System.out.println("Dish not found.");
                    } else {
                        System.out.print("New name: ");
                        String newName = scanner.nextLine();
                        System.out.print("New category: ");
                        String newCategory = scanner.nextLine();
                        System.out.print("New price: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();

                        dish.setName(newName);
                        dish.setCategory(newCategory);
                        dish.setPrice(newPrice);

                        System.out.println("Dish updated successfully!");
                    }
                }
                case 4 -> {
                    System.out.print("Enter the name of the dish to remove: ");
                    String nameToRemove = scanner.nextLine();

                    boolean removed = restaurant.getMenu().removeIf(m -> m.getName().equalsIgnoreCase(nameToRemove));

                    if (removed) {
                        System.out.println("Dish removed successfully!");
                    } else {
                        System.out.println("Dish not found.");
                    }
                }
                case 5 -> {
                    System.out.print("Client name: ");
                    String name = scanner.nextLine();
                    System.out.print("Phone: ");
                    String tel = scanner.nextLine();

                    Client client = new Client(name, tel, restaurant);
                    restaurant.addClient(client);

                    System.out.println("Client registered successfully!");
                }
                case 6 -> {
                    if (restaurant.getClients().isEmpty()) {
                        System.out.println("No clients registered.");
                    } else {
                        restaurant.getClients().forEach(System.out::println);
                    }
                }
                case 7 -> {
                    if (restaurant.getClients().isEmpty()) {
                        System.out.println("No clients registered.");
                        break;
                    }
                    if (restaurant.getMenu().isEmpty()) {
                        System.out.println("No dishes available.");
                        break;
                    }

                    System.out.print("Enter client name: ");
                    String clientName = scanner.nextLine();

                    Client client = restaurant.getClients().stream()
                            .filter(c -> c.getName().equalsIgnoreCase(clientName))
                            .findFirst()
                            .orElse(null);

                    if (client == null) {
                        System.out.println("Client not found.");
                        break;
                    }

                    Order order = new Order(client);

                    while (true) {
                        System.out.print("Enter dish name to add (or type 'done' to finish): ");
                        String dishName = scanner.nextLine();

                        if (dishName.equalsIgnoreCase("done")) break;

                        Menu menuItem = restaurant.getMenu().stream()
                                .filter(m -> m.getName().equalsIgnoreCase(dishName))
                                .findFirst()
                                .orElse(null);

                        if (menuItem != null) {
                            order.addItem(menuItem);
                            System.out.println("Dish added to order.");
                        } else {
                            System.out.println("Dish not found.");
                        }
                    }

                    restaurant.addOrder(order);
                    System.out.println("Order placed successfully!");
                }
                case 8 -> { // Update order
                    System.out.print("Enter order ID to update: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();

                    Order order = restaurant.getOrders().stream()
                            .filter(o -> o.getId() == orderId)
                            .findFirst()
                            .orElse(null);

                    if (order == null) {
                        System.out.println("Order not found.");
                        break;
                    }

                    System.out.println("Current items: " + order.getItems());
                    System.out.print("Enter dish name to remove: ");
                    String dishToRemove = scanner.nextLine();

                    order.getItems().removeIf(m -> m.getName().equalsIgnoreCase(dishToRemove));

                    System.out.print("Enter dish name to add (or leave blank to skip): ");
                    String newDish = scanner.nextLine();

                    if (!newDish.isBlank()) {
                        Menu dish = restaurant.getMenu().stream()
                                .filter(m -> m.getName().equalsIgnoreCase(newDish))
                                .findFirst()
                                .orElse(null);
                        if (dish != null) {
                            order.addItem(dish);
                            System.out.println("Dish added.");
                        } else {
                            System.out.println("Dish not found.");
                        }
                    }
                    System.out.println("Order updated!");
                }
                case 9 -> {
                    if (restaurant.getOrders().isEmpty()) {
                        System.out.println("No orders placed.");
                    } else {
                        restaurant.getOrders().forEach(System.out::println);
                    }
                }
                case 10 -> { // Delete order
                    System.out.print("Enter order ID to delete: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();

                    boolean removed = restaurant.getOrders().removeIf(o -> o.getId() == orderId);

                    if (removed) {
                        System.out.println("Order deleted successfully!");
                    } else {
                        System.out.println("Order not found.");
                    }
                }
                case 11 -> {
                    System.out.println("Exiting restaurant menu...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}