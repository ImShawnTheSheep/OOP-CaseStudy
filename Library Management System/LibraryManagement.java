import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class LibraryManagement {
    private static Scanner input = new Scanner(System.in);
    private static Library library = new Library();

    // method to add a book to the library
    private static void addBook() {
        clearScreen();

        System.out.print("Enter the title of the book: ");
        String title = input.nextLine().trim();
        if (!inputCatch(title)) {
            addBook();
            return;
        }

        System.out.println("+---------------------------+");
        System.out.print("Enter the author of the book: ");
        String author = input.nextLine().trim();
        if (!inputCatch(author)) {
            addBook();
            return;
        }

        if (library.containsBook(title, author)) {
            System.out.println("The book \"" + title + "\" by " + author + " already exists!");
            return;
        }

        Book book = new Book(title, author);
        library.addBook(book);
    }

    // method to remove a book from the library
    private static void removeBook() {
        clearScreen();
        System.out.print("Enter the ID of the book you want to remove: ");
        int id = inputCatch(input);
        if (id == 0) {
            removeBook();
            return;
        }

        System.out.println("+---------------------------+");

        if (library.findBook(id) == null) {
            System.out.println("Book not found.");
            return;
        }

        library.removeBook(id);
        System.out.println("Book removed successfully.");
    }

    // method to display all available books in the library
    private static void displayAvailableBooks() {
        clearScreen();
        List<Book> availableBooks = library.getAvailableBooks();
        System.out.println("+---------------------------+");

        if (availableBooks.isEmpty())
            System.out.println("No books available in the library.");

        if (!availableBooks.isEmpty()) {
            System.out.println("Available books in the library: ");
            for (Book book : availableBooks) {
                System.out.println("ID: " + book.getID());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor() + "\n");
            }
        }
    }

    // method to borrow a book from the library
    private static void borrowBook() {
        clearScreen();

        // get book to be borrowed
        System.out.print("Enter the ID of the book to borrow: ");

        int id = inputCatch(input);
        if (id == 0) {
            borrowBook();
            return;
        }

        System.out.println("+---------------------------+");

        Book book = library.findBook(id);

        /* checks if book is available */
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!book.isAvailable())
            // Book is now out of the library
            System.out.println("The book " + book.getTitle() + " has been borrowed.");

        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed successfully.");
        }
    }

    // method to return a book to the library
    private static void returnBook() {
        clearScreen();

        // get book to be returned
        System.out.print("Enter the ID of the book to return: ");

        int id = inputCatch(input);
        if (id == 0) {
            returnBook();
            return;
        }

        System.out.println("+---------------------------+");

        Book book = library.findBook(id);

        /* checks if book is available */
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.isAvailable())
            System.out.println("The book " + book.getTitle() + " is already in the library.");
        if (!book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book returned successfully.");
        }
    }

    public static void run() {
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
        int choice = inputCatch(input);

        switch (choice) {
            case 1:
                addBook();
                pause();
                run();
                break;
            case 2:
                removeBook();
                pause();
                run();
                break;
            case 3:
                displayAvailableBooks();
                pause();
                run();
                break;
            case 4:
                borrowBook();
                pause();
                run();
                break;
            case 5:
                returnBook();
                pause();
                run();
                break;
            case 6:
                System.out.println("You have chosen to exit this program.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                pause();
                run();
                break;
        }

        clearScreen();
        System.out.println("----------------------------------------------------");
        System.out.println("Program Ended. ");
        System.out.print("Thank you for using the Library Management System.");
    }

    // utility method to clear the console screen
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // utility method to pause and wait for user input
    private static void pause() {
        System.out.print("Press the enter key to continue...");
        input.nextLine();
    }

    private static boolean inputCatch(String item) {
        try {
            if (item.isEmpty()) {
                System.out.println("Null input. Enter a valid string!");
                pause();
                return false;
            }
            if (!item.matches("[a-zA-Z0-9 ]+")) {
                System.out.println("Invalid input. Please enter a valid string!");
                pause();
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid string.");
            pause();
            return false;
        }
    }

    private static int inputCatch(Scanner input) {
        int choice = 0;

        try {
            choice = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            input.nextLine();
            System.out.println("Invalid input. Please enter a valid integer.");
            pause();
            return 0;
        }

        return choice;
    }
}