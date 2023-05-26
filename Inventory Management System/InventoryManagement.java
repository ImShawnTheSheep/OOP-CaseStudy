import java.util.Scanner;
import java.util.Map;
import java.util.InputMismatchException;

public class InventoryManagement {

   private static Scanner input = new Scanner(System.in);
   private static Inventory inventory = new Inventory();

   /* static method to call object from Inventory--calls add method */
   private static void insertItem() {
      Util.clearScreen(); // clears the console

      System.out.print("Enter an item you would like to save into the inventory: ");
      String choice = "";
      String item = input.nextLine().trim();
      if (!inputCatch(item)) {
         insertItem();
         return;
      }

      // checks if the item already is in the inventory and will ask the user if they
      // want to the existing quantity
      if (inventory.containsItem(item)) {
         System.out.println("The item \"" + item + "\" already exists!");
         System.out.print("Would you like to add the item's quantity? (Y/N): ");
         choice = input.nextLine().trim();
      }

      // ignore case
      if (choice.equalsIgnoreCase("Y") || choice.isEmpty() || !inventory.containsItem(item)) {
         inventory.addItem(item, inputCatch());
         displayInventory();
      }

      System.out.print("\nWould you like to add another item? (Y/N): ");
      choice = input.nextLine().trim();
      if (choice.equalsIgnoreCase("Y") || choice.isEmpty())
         insertItem(); // calls insertItem()
   }

   /* static method to call object from Inventory--calls delete method */
   private static void deleteItem() {
      Util.clearScreen(); // clears the console
      boolean callMethod = false;

      System.out.print("Enter an item you would like to remove from the inventory: ");
      String item = input.nextLine().trim();
      if (!inputCatch(item)) {
         deleteItem();
         return;
      }

      // Checks if the inventory does not have the item
      if (!inventory.containsItem(item)) {
         System.out.println("The item \"" + item + "\" doesn't exist!");
         System.out.print("\nWould you like to add that item instead? (Y/N):");
         String choice = input.nextLine().trim();
         if (choice.equalsIgnoreCase("Y") || choice.isEmpty())
            callMethod = true;
      }

      // Checks if the inventory have the item
      if (inventory.containsItem(item)) {
         inventory.removeItem(item);
         System.out.println(!inventory.containsItem(item) ? "\nThe item \"" + item + "\"" + " has been removed!" : "");
         displayInventory(); // shows the inventory table
      }

      // asks the user if they want to remove another item
      if (!callMethod) {
         System.out.print("\nWould you like to remove another item? (Y/N): ");
         String choice = input.nextLine().trim();
         if (choice.equalsIgnoreCase("Y") || choice.isEmpty())
            deleteItem();
      }

      // if user chooses to add an item, calls insertItem()
      if (callMethod)
         insertItem();
   }

   /* static method to call object from Inventory--calls checking method */
   private static void checkItemQuantity() {
      Util.clearScreen(); // clears the console

      displayInventory(); // displays the table for inventory

      System.out.print("Enter the item you want to check for its quantity: ");
      String choice = "";
      String item = input.nextLine().trim();
      if (!inputCatch(item)) {
         checkItemQuantity();
         return;
      }

      // checks if the inventory contains that item, and if not--ask if user wants to
      // add an item
      if (!inventory.containsItem(item))
         System.out.println("The item \"" + item + "\" doesn't exist in this inventory.");

      // if the inventory contains the item, show the item and its quantity
      if (inventory.containsItem(item))
         System.out.println("The item \"" + item + "\" has a quantity of " + inventory.getQuantity(item));

      System.out.print("\nWould you like to add another item? (Y/N): ");
      choice = input.nextLine().trim();
      if (choice.equalsIgnoreCase("Y") || choice.isEmpty())
         checkItemQuantity();
   }

   /* static method to display all items in Inventory */
   private static void displayInventory() {
      if (inventory.getItems().isEmpty()) {
         System.out.println("\nThe inventory is empty!");
         Util.pause();
         return;
      }

      System.out.println("+-------------------------+");
      System.out.println("| Item           | Qty.   |");
      System.out.println("+-------------------------+");
      /* Output prompt or visualized items and quantity table */
      for (Map.Entry<String, Integer> entry : inventory.getItems().entrySet())
         System.out.printf("| %-14s | %-6d |\n", entry.getKey(), entry.getValue());
      System.out.println("+-------------------------+");
   }

   /* main method containing the menu console UI, and switch case operations */

   public static void run() {
      Util.clearScreen(); // clears the console

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
      int choice = 0;

      /* try-catch block to catch invalid input */
      try {
         choice = input.nextInt();
         input.nextLine();
      } catch (InputMismatchException e) {
         input.nextLine();
         System.out.println("\nInvalid input!");
         Util.pause();
         run();
      }

      /* switch case choices, from 1 - 4, and default when user inputs invalid data */
      switch (choice) {
         case 1:
            insertItem();
            run();
            break;
         case 2:
            deleteItem();
            run();
            break;
         case 3:
            checkItemQuantity();
            run();
            break;
         case 4:
            System.out.println("You have chosen to exit this program.");
            break;
         /* terminates loop from while loop in main */
         default:
            System.out
                  .println(
                        "The option you have chosen is either not available from the menu \n or is not valid. ");
            break;
      }
   }

   private static int inputCatch() {
      boolean validInput = false;
      int quantity = 0;
      while (!validInput) {
         try {
            System.out.print("Enter the quantity of the item you would like to add: ");
            quantity = input.nextInt();
            input.nextLine();
            validInput = true;
         } catch (InputMismatchException e) {
            input.nextLine();
            System.out.println("Invalid input. Please enter a valid integer.");
            Util.pause();
            Util.clearScreen();
         }
      }
      return quantity;
   }

   private static boolean inputCatch(String item) {
      try {
         if (item.isEmpty()) {
            System.out.println("Null input. Enter a valid string!");
            Util.pause();
            return false;
         }
         if (!item.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input. Please enter a valid string!");
            Util.pause();
            return false;
         }
         return true;
      } catch (Exception e) {
         System.out.println("Invalid input. Please enter a valid string.");
         Util.pause();
         return false;
      }
   }
}