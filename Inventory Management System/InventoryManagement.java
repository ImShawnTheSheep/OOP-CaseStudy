import java.util.Scanner;
import java.util.HashMap;

class Inventory {
    HashMap<String, Integer> items = new HashMap<String, Integer>();

    // adding item
    public void AddItem(String item, int quantity){
        items.put(item, quantity);
        System.out.println(item + "with a number of" + quantity + "has been added.");
    }
    // removing item
    public void DeleteItem(String item, int quantity) {
        items.remove(item, quantity);
        System.out.println(item + "with a number of" + quantity + "has been remove.");
    }
}

public class InventoryManagement {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello World!");
        boolean exit = false;
        while (!exit) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Check item quantity");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
        }

        scanner.close();
        System.out.println("Exiting Inventory Management System");
    }

}
