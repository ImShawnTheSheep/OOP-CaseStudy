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
      if (!items.containsKey(item)) {
         items.put(item, quantity);
      } else {
         int current_quantity = items.get(item);
         items.put(item, current_quantity + quantity);
      }
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
      return item.getOrDefault(item, 0);
   }
}

public class InventoryManagement {

   private static Scanner input = new Scanner(System.in);
   private static Inventory inventory = new Inventory();

   /* static method to call object from Inventory--calls add method */
   private static void insertItem() {
      clearScreen();

      System.out.print("Enter an item you would like to save into the database: ");
      String item = input.nextLine().trim();

      if (!inventory.containsItem(item)) {
         System.out.print("Enter the quantity of the item you would like to add: ");
         int quantity = input.nextInt();
         inventory.addItem(item, quantity);

         fetchInventory();
      } else {
         System.out.println("The item \"" + item + "\" already exists!");
         System.out.print("Would you like to add quantity? (Y/N): ");
         String choice = input.nextLine().trim();

         if (choice.equalsIgnoreCase("Y")) {
            System.out.print("Enter the quantity of the item you would like to add: ");
            int quantity = input.nextInt();
            inventory.addItem(item, quantity);
         }
      }

      input.nextLine();
      System.out.print("\nWould you like to add another item? (Y/N): ");
      String choice = input.nextLine().trim();

      if (choice.equalsIgnoreCase("Y") || choice.isEmpty())
         insertItem();
   }

   /* static method to call object from Inventory--calls delete method */
   private static void deleteItem() {
      clearScreen();
      boolean callMethod = false;

      System.out.print("Enter an item you would like to remove from the database: ");
      String item = input.nextLine().trim();

      if (inventory.containsItem(item)) {
         inventory.removeItem(item);
         System.out.println(
               !inventory.containsItem(item) ? "\nThe item \"" + item + "\"" + " has been removed!" : "");
         fetchInventory();
      } else {
         System.out.println("The item \"" + item + "\" doesn't exist!");
         System.out.print("\nWould you like to add instead? (Y/N):");
         String choice = input.nextLine().trim();
         if (choice.equalsIgnoreCase("Y"))
            callMethod = true;
      }

      if (callMethod) {
         insertItem();
      } else {
         System.out.print("\nWould you like to remove another item? (Y/N): ");
         String choice = input.nextLine().trim();

         if (choice.equalsIgnoreCase("Y") || choice.isEmpty())
            deleteItem();
      }
   }

   /* static method to call object from Inventory--calls checking method */
   private static void checkItemQuantity() {
      clearScreen();

      fetchInventory();

      System.out.print("Enter item you want to check the quantity: ");
      String item = input.nextLine().trim();

      if (inventory.containsItem(item)) {
         System.out.println(
               "The item \"" + item + "\" has a quantity of " + inventory.getQuantity(item));
         pause();
      } else {
         System.out.println("The item \"" + item + "\" doesn't exist");
         System.out.print("\nWould you like to add instead? (Y/N):");
         String choice = input.nextLine().trim();
         if (choice.equalsIgnoreCase("Y"))
            insertItem();
      }
   }

   /* static method to fetch all items in Inventory */
   private static void fetchInventory() {
      System.out.println("+-------------------------+");
      System.out.println("| Item           | Qty.   |");
      System.out.println("+-------------------------+");
      for (Map.Entry<String, Integer> entry : inventory.getItems().entrySet())
         System.out.printf("| %-14s | %-6d |\n", entry.getKey(), entry.getValue());
      System.out.println("+-------------------------+");
   }

   /* main method containing the menu console UI, and switch case operations */
   public static void main(String[] args) {
      boolean exit = false;
      do {
         clearScreen();

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

         /* switch case choices, from 1 - 4, and default when user inputs invalid data */
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
            /* terminates loop from while loop in main */
            default:
               System.out.println(
                     "The choice you have chosen is either not available from the list \n or is not valid. ");
               break;
         }
      } while (!exit);
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
      System.out.print("\nPress the enter key to continue...");
      input.nextLine();
   }
}