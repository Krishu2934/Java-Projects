import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RestaurantBillingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu with item prices
        Map<String, Double> menu = new HashMap<>();
        menu.put("Burger", 5.99);
        menu.put("Pizza", 8.49);
        menu.put("Salad", 3.99);
        menu.put("Drink", 1.99);

        // Customer's order
        Map<String, Integer> order = new HashMap<>();

        System.out.println("Welcome to the Restaurant Billing Machine!");

        while (true) {
            System.out.println("\nMenu:");
            for (Map.Entry<String, Double> entry : menu.entrySet()) {
                System.out.println(entry.getKey() + ": $" + entry.getValue());
            }

            System.out.print("\nEnter item (or 'done' to finish ordering): ");
            String item = scanner.nextLine();

            if (item.equalsIgnoreCase("done")) {
                break;
            }

            if (menu.containsKey(item)) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                order.put(item, quantity);
            } else {
                System.out.println("Invalid item. Please choose from the menu.");
            }
        }

        // Calculate total bill
        double totalBill = 0.0;
        System.out.println("\nOrder Summary:");
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            double price = menu.get(item);
            double itemTotal = price * quantity;
            totalBill += itemTotal;

            System.out.println(item + " x" + quantity + ": $" + itemTotal);
        }

        System.out.println("\nTotal Bill: $" + totalBill);

        System.out.println("\nThank you for dining with us!");

        scanner.close();
    }
}
