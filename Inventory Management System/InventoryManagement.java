import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Inventory {
   private Map<String, Integer> items;

   public Inventory() {
      items = new HashMap<>();
   }

   // adding item
   public void addItem(String item, int quantity) {
      if (items.containsKey(item)) {
         int current_quantity = items.get(item);
         items.put(item, current_quantity + quantity);
      }
      if (!items.containsKey(item)) items.put(item, quantity);
   }

   // removing item
   public void removeItem(String item) {
      items.remove(item);
   }

   // check if item exist
   public boolean containsItem(String itemName) {
      return items.containsKey(itemName);
   }

   // get items
   public Map<String, Integer> getItems() {
      return items;
   }

   // get quantity
   public int getQuantity(String item) {
      return items.getOrDefault(item, 0);
   }
}

public class InventoryManagement {

   private static Scanner input = new Scanner(System.in);
   private static Inventory inventory = new Inventory();

   // static method to call object from Inventory--calls add method
   private static void insertItem() {
      clearScreen(); // clears the console

      System.out.print("Enter an item you would like to save into the inventory: ");
      String choice = "";
      String item = input.nextLine().trim();


      // if the item does not already exist in the inventory
      if (!inventory.containsItem(item)) {
         System.out.print("Enter the quantity of the item you would like to add: ");
         int quantity = input.nextInt();
         inventory.addItem(item, quantity);

         // display the updated inventory
         fetchInventory();

         // if the item already exists in the inventory
      } else {
         System.out.println("The item \"" + item + "\" already exists!");
         System.out.print("Would you like to add quantity? (Y/N): ");
         String choice = input.nextLine().trim();

         // if the user wants to add quantity to the existing item
         if (choice.equalsIgnoreCase("Y")) {
            System.out.print("Enter the quantity of the item you would like to add: ");
            int quantity = input.nextInt();
            inventory.addItem(item, quantity);
         }

      }

      // checks if the item is not in the inventory
      if (!inventory.containsItem(item)) {
         System.out.print("Enter the quantity of the item you would like to add: ");
         int quantity = input.nextInt();
         inventory.addItem(item, quantity);
         fetchInventory(); // shows the inventory table
      } 

      input.nextLine();
      System.out.print("\nWould you like to add another item? (Y/N): ");

      String choice = input.nextLine().trim();

      // if the user wants to add another item (either chooses 'Y' or enters an empty input)
      if (choice.equalsIgnoreCase("Y") || choice.isEmpty())
         insertItem(); // recursive call to the insertItem() method to continue adding items

   }

   // static method to call object from Inventory--calls delete method
   private static void deleteItem() {
      clearScreen(); // clears the console
      boolean callMethod = false;

      System.out.print("Enter an item you would like to remove from the inventory: ");
      String choice = "";
      String item = input.nextLine().trim();

      // if the item exists in the inventory
      if (inventory.containsItem(item)) {
         inventory.removeItem(item); // remove the item from the inventory
         // if the item is no longer present in the inventory, display a success message
         System.out.println(
               !inventory.containsItem(item) ? "\nThe item \"" + item + "\"" + " has been removed!" : "");
         fetchInventory(); // fetch and display the updated inventory

         // if the item doesn't exist in the inventory
      } else {
         System.out.println("The item \"" + item + "\" doesn't exist!");
         System.out.print("\nWould you like to add instead? (Y/N):");
         String choice = input.nextLine().trim();
         if (choice.equalsIgnoreCase("Y"))
            callMethod = true; // set a flag to indicate that the insertItem() method should be called
      }
      // if the flag is set, call the insertItem() method to allow the user to add a new item
      if (callMethod) {
         insertItem();

         // if the flag is not set
      } else {
         System.out.print("\nWould you like to remove another item? (Y/N): ");
         String choice = input.nextLine().trim();

         // if the user wants to remove another item (either chooses 'Y' or enters an empty input)
         if (choice.equalsIgnoreCase("Y") || choice.isEmpty())
            deleteItem(); // recursive call to the deleteItem() method to continue removing items

      }

      // if user chooses to add an item, calls insertItem()
      if (callMethod) insertItem();
   }

   // static method to call object from Inventory--calls checking method
   private static void checkItemQuantity() {
      clearScreen(); // clears the console


      // fetches and displays the current inventory
      fetchInventory();

      System.out.print("Enter item you want to check the quantity: ");
      String item = input.nextLine().trim(); // reads the item name from the user

      // if the item exists in the inventory
      if (inventory.containsItem(item)) {
         // display the quantity of the item in the inventory
         System.out.println(
               "The item \"" + item + "\" has a quantity of " + inventory.getQuantity(item));
         pause(); // pause the program to allow the user to read the information

         // if the item doesn't exist in the inventory
      } else {
         System.out.println("The item \"" + item + "\" doesn't exist");
         System.out.print("\nWould you like to add instead? (Y/N):");
         String choice = input.nextLine().trim();

         // if the user wants to add the item instead (chooses 'Y')
         if (choice.equalsIgnoreCase("Y"))
            insertItem(); // call the insertItem() method to add a new item
      }

   }

   // static method to fetch all items in Inventory
   private static void fetchInventory() {
      System.out.println("+-------------------------+");
      System.out.println("| Item           | Qty.   |");
      System.out.println("+-------------------------+");

      /* Output prompt or visualized items and quantity table  */

      for (Map.Entry<String, Integer> entry : inventory.getItems().entrySet())
         // print the item name and quantity in a formatted table row
         System.out.printf("| %-14s | %-6d |\n", entry.getKey(), entry.getValue());
      System.out.println("+-------------------------+");
   }

   // main method containing the menu console UI, and switch case operations
   public static void main(String[] args) {
      boolean exit = false;
      do {
         clearScreen(); // clears the console

         // UI (console)
         System.out.println("+-----------------------------+");
         System.out.println("| Inventory Management System |");
         System.out.println("+-----------------------------+");
         System.out.println("1. Add item");
         System.out.println("2. Remove item");
         System.out.println("3. Check item quantity");
         System.out.println("4. Exit");
         System.out.println("-------------------------------");
         System.out.print("Enter your choice: ");
         int choice = input.nextInt();
         input.nextLine(); // clears buffer for next input

         // switch case choices, from 1 - 4, and default when user inputs invalid data
         switch (choice) {
            case 1:
               insertItem();
               break;
            case 2:
               deleteItem();
               break;
            case 3:
               checkItemQuantity();
               break;
            case 4:
               System.out.println("You have chosen to exit this program.");
               exit = true;
               break;
            // terminates loop from while loop in main
            default:
               System.out.println("The option you have chosen is either not available from the menu \n or is not valid. ");
               break;
         }
      } while (!exit);
      /* output prompt for exiting the program */
      clearScreen(); // clears the console
      System.out.println("----------------------------------------------------");
      System.out.println("Program Ended. ");
      System.out.print("Thank you for using the Inventory Management System.");
   }

   // clear screen method
   private static void clearScreen() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
   }

   // pause method
   private static void pause() {
      System.out.print("\nPress the enter key to continue...");
      input.nextLine();
   }
}