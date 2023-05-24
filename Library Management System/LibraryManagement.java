import java.util.Scanner;

class Book {
    public Book(String title, String author) {
    }
}
class Library {

}

public class LibraryManagement {
    private static Scanner input = new Scanner(System.in);
    private static void addBook() {
        clearScreen();
        input.nextLine();

        System.out.print("Enter the title of the book: ");
        String title = input.nextLine();

        System.out.print("Enter the author of the book: ");
        String author = input.nextLine();

        Book book = new Book(title, author);

    }

    private static void removeBook() {
        clearScreen();
        System.out.println("Enter the ID of the book you want to remove: ");

    }

    private static void displayAvailableBooks() {
        clearScreen();

    }

    private static void borrowBook() {
        clearScreen();
        System.out.println("Enter the ID of the book to borrow: ");

    }

    private static void returnBook() {
        clearScreen();
        System.out.println("Enter the ID of the book to return: ");

    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            clearScreen();
            System.out.println("+---------------------------+");
            System.out.println("| Library Management System |");
            System.out.println("+---------------------------+");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Display available books");
            System.out.println("4. Borrow book");
            System.out.println("5. Return book");
            System.out.println("6. Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    pause();
                    break;
                case 2:
                    removeBook();
                    pause();
                    break;
                case 3:
                    displayAvailableBooks();
                    pause();
                    break;
                case 4:
                    borrowBook();
                    pause();
                    break;
                case 5:
                    returnBook();
                    pause();
                    break;
                case 6:
                    System.out.println("You have chosen to exit this program.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }

        clearScreen();
        System.out.println("----------------------------------------------------");
        System.out.println("Program Ended. ");
        System.out.print("Thank you for using the Library Management System.");
    }
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

     private static void pause() {
        System.out.print("Press the enter key to continue...");
        input.nextLine();
    }
}