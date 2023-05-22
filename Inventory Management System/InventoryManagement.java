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

    public void checkItemQuantity(String item, int quantity) {
        //prototyping
    }
}

public class InventoryManagement {
    private static Scanner input = new Scanner(System.in);
    private static Inventory myObj = new Inventory();

    private static void pause() {
        System.out.print("Press the enter key to continue...");
        input.nextLine();
        input.nextLine();
    }

    private static void insertItemQuantity(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("Enter an item you would like to save into the database: ");
        String insertItem = input.nextLine();
        System.out.print("Enter the quantity of the item you would like to add: ");
        int insertQuantity = input.nextInt();

        myObj.addItem(insertItem, insertQuantity);
    }

    private static void deleteItemQuantity(){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("Enter the name of the item you would like to delete: ");
        String removeItem = input.nextLine();
        System.out.print("Enter the quantity of the item you would like to delete: ");
        int removeQuantity = input.nextInt();

        myObj.deleteItem(removeItem, removeQuantity);
    }

    private static void checkItemQuantity() {
        // prototyping
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
/* 
    private static boolean switchCase(int option, boolean end) {
        Inventory classObj = new Inventory();
        switch(option) {
            case 1: 
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.print("Enter an item you would like to save into the database: ");
            String insertItem = input.nextLine();
            System.out.print("Enter the quantity of the item you would like to add: ");
            int insertQuantity = input.nextInt();

            classObj.addItem(insertItem, insertQuantity);
            pause();
            break;

            case 2:
            System.out.print("Enter the name of the item you would like to delete: ");
            String removeItem = input.nextLine();
            System.out.print("Enter the quantity of the item you would like to delete: ");
            int removeQuantity = input.nextInt();

            classObj.deleteItem(removeItem, removeQuantity);
            pause();
            break;

            case 3:
            System.out.print("Sample Prompt: ");
            //checkItemQuantity();
            pause();
            break;

            case 4:
            System.out.print("You have chosen to exit this program.");
            return true;
        
            default:
            System.out.println("The choice you have chosen is either not available from the list \n or is not valid. ");
        }
        return false;
    }
*/

/* main method containing the menu console UI, and switch case operations */
    public static void main(String[] args) {
        boolean exit = false;
        while (exit == false) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Inventory Management System");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Check item quantity");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();
            //exit = switchCase(choice, exit); ---used for the first iteration of the switch case as seen from commented lines 62 - 104

            switch(choice) {
                case 1:
                    insertItemQuantity();
                    pause();
                    break;
                case 2:
                    deleteItemQuantity();
                    pause();
                    break;
                case 3:
                    checkItemQuantity();
                    pause();
                    break;
                case 4:
                    System.out.print("You have chosen to exit this program.");
                    exit = true;
                    break;
                default:
                    System.out.println("The choice you have chosen is either not available from the list \n or is not valid. ");
            }
        }
        input.close();
        System.out.println("\nThank you for using the Inventory Management System.");
    }
}