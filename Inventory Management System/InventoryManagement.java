import java.util.Scanner;
import java.util.HashMap;

class Inventory {
    HashMap<String, Integer> items = new HashMap<String, Integer>();

    // adding item
    public void addItem(String item, int quantity) {
        items.put(item, quantity);
        System.out.println(item + " with a quantity of " + quantity + " has been added.");
    }
    // removing item
    public void deleteItem(String item, int quantity) {
        items.remove(item, quantity);
        System.out.println(item + " with a quantity of " + quantity + " has been removed.");
    }
}

public class InventoryManagement {
    private static Scanner input = new Scanner(System.in);

    private static boolean switchCase(int option, boolean end) {
        Inventory classObj = new Inventory();
        switch(option) {
            case 1: 
            System.out.print("Enter an item you would like to save into the database: ");
            String insertItem = input.nextLine();
            System.out.print("Enter the quantity of the item you would like to add: ");
            int insertQuantity = input.nextInt();

            classObj.addItem(insertItem, insertQuantity);
            break;

            case 2:
            System.out.print("Enter the name of the item you would like to delete: ");
            String removeItem = input.nextLine();
            System.out.print("Enter the quantity of the item you would like to delete: ");
            int removeQuantity = input.nextInt();

            classObj.deleteItem(removeItem, removeQuantity);
            break;

            case 3:
            System.out.print("Sample Prompt: ");
            //checkItemQuantity();
            break;

            case 4:
            System.out.print("You have chosen to exit this program.");
            return true;
        
            default:
            System.out.println("The choice you have chosen is either not available from the list \n or is not valid. ");
        }
        return false;
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (exit == false) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Check item quantity");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();
            exit = switchCase(choice, exit);
        }
        input.close();
        System.out.println("\nThank you for using the Inventory Management System.");
    }
}