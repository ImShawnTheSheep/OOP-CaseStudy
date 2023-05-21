import java.util.Scanner;

class Inventory {

}

class InventoryManagement {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
