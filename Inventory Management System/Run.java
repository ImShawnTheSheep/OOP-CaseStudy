
public class Run {

    public static void main(String[] args) {
        InventoryManagement.run(); // calls the Inventory Management class from main

        /* output prompt for exiting the program */
        Util.clearScreen(); // clears the console
        System.out.println("----------------------------------------------------");
        System.out.println("Program Ended. ");
        System.out.print("Thank you for using the Inventory Management System.");
    }
}