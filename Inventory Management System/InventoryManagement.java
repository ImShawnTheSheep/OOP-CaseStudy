import java.util.Scanner;
import java.util.HashMap;

class Inventory {
    private static HashMap<String, Integer> items = new HashMap<String, Integer>();

    // adding item
    public void addItem(String item, int quantity) {
        if (!items.containsKey(item)) {
            items.put(item, quantity);
            System.out.println(item + " with a quantity of " + quantity + " has been added.");
        } else {
            System.out.println("Item already exist! Adding quantity...");
            int current_quantity = items.get(item);
            items.put(item, current_quantity + quantity);
            System.out.println(item + " has now a quantity of " + items.get(item));
        }
    }

    // removing item
    public void removeItem(String item, int quantity) {
        items.remove(item, quantity);
        System.out.println(item + " with a quantity of " + quantity + " has been removed.");
    }
    
    // check item
    public void checkItemQuantity(String item) {
        if (items.containsKey(item)) {
            int quantity = items.get(item);
            System.out.println(item + " has a quantity of " + quantity);
        } else {
            System.out.println(item + " does not exist in the inventory.");
        }
    }
}

public class InventoryManagement {

    private static Scanner input = new Scanner(System.in);
    private static Inventory inventory = new Inventory();

    /* static method to call object from Inventory--calls add method */
    private static void insertItemQuantity() {
        boolean exit = false;
        do {
            clearScreen();

            System.out.print("Enter an item you would like to save into the database: ");
            String insertItem = input.nextLine();
            System.out.print("Enter the quantity of the item you would like to add: ");
            int insertQuantity = input.nextInt();

            inventory.addItem(insertItem, insertQuantity);
            input.nextLine(); // clears buffer for next input

            System.out.print("Would you like to add another item? (Y/N): ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("N")) {
                exit = true;
            }
        } while (!exit);
    }

    /* static method to call object from Inventory--calls delete method */
    private static void removeItemQuantity() {
        boolean exit = false;
        do {
            clearScreen();
            
            System.out.print("Enter the name of the item you would like to delete: ");
            String removeItem = input.nextLine();
            System.out.print("Enter the quantity of the item you would like to delete: ");
            int removeQuantity = input.nextInt();

            inventory.removeItem(removeItem, removeQuantity);
            input.nextLine(); // clears buffer for next input

            System.out.print("Would you like to remove another item? (Y/N): ");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("N")) {
                exit = true;
            }
        } while (!exit);
    }

    /* static method to call object from Inventory--calls checking method */
    private static void checkItemQuantity() {
        clearScreen();
        System.out.print("Enter the name of the item you would like to check: ");
        String item = input.nextLine();

        inventory.checkItemQuantity(item);

        pause(); }

    /* main method containing the menu console UI, and switch case operations */
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            clearScreen();

            // UI (console)
            System.out.println("+-----------------------------+");            System.out.println("| Inventory Management System |");System.out.println("+-----------------------------+");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Check item quantity");
            System.out.println("4. Exit");
            System.out.println("-------------------------------");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // clears buffer for next input

            /* switch case choices, from 1 - 4, and default when user inputs invalid data */
            switch (choice) {
                case 1:
                    insertItemQuantity();
                    pause();
                    break;
                case 2:
                    removeItemQuantity();
                    pause();
                    break;
                case 3:
                    checkItemQuantity();
                    pause();
                    break;
                case 4:
                    System.out.println("You have chosen to exit this program.");
                    exit = true;
                    break;
                /* terminates loop from while loop in main */
                default:
                    System.out.println("The choice you have chosen is either not available from the list \n or is not valid. ");
                    break;
            }
        }
        input.close();
        clearScreen();
        System.out.println("----------------------------------------------------");
        System.out.println("Program Ended. ");
        System.out.print("Thank you for using the Inventory Management System.");
    }

    /* clear screen method */
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /* pause method */
    private static void pause() {
        System.out.print("Press the enter key to continue...");
        input.nextLine();
    }
}