import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private static int nextID = 001; // keeps track of the next available book ID

    private int id; // unique ID of the book
    private String title; // title of the book
    private String author; // author of the book
    private boolean available; // indicates if the book is available for borrowing or not

    // creates a book object
    public Book(String title, String author) {
        this.id = nextID++;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    // gets the book ID
    public int getID() {
        return id;
    }

    // gets the book title
    public String getTitle() {
        return title;
    }

    // gets the book author
    public String getAuthor() {
        return author;
    }

    // gets the book availability
    public boolean isAvailable() {
        return available;
    }

    // sets the book availability
    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Library {
    private List<Book> books;

    // creates a library object
    public Library() {
        this.books = new ArrayList<>();
    }

    // method to add books in library
    public void addBook(Book book) {
        books.add(book);
    }

    // method to remove books in library
    public void removeBook(int id) {
        for (Book book : books) {
            if (book.getID() == id) {
                books.remove(book);
                return;
            }
        }
    }

    // method to find books in the library
    public Book findBook(int id) {
        for (Book book : books) {
            if (book.getID() == id) {
                return book;
            }
        }
        return null;
    }

    // method to get all available books in the library
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

}

public class LibraryManagement {
    private static Scanner input = new Scanner(System.in);
    private static Library library = new Library();

    // method to add a book to the library
    private static void addBook() {
        clearScreen();

        System.out.print("Enter the title of the book: ");
        String title = input.nextLine();

        System.out.print("Enter the author of the book: ");
        String author = input.nextLine();

        Book book = new Book(title, author);
        library.addBook(book);
    }

    // method to remove a book from the library
    private static void removeBook() {
        clearScreen();
        System.out.print("Enter the ID of the book you want to remove: ");
        int id = input.nextInt();

        library.removeBook(id);
    }

    // method to display all available books in the library
    private static void displayAvailableBooks() {
        clearScreen();
        List<Book> availableBooks = library.getAvailableBooks();

        if (availableBooks.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
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
        System.out.println("Enter the ID of the book to borrow: ");
        int id = input.nextInt();
        input.nextLine();

        Book book = library.findBook(id);

        // checks if book is available
        if (book == null) {
            System.out.println("Book not found.");
        } else if (!book.isAvailable()) {
            // book is now out of the library
            System.out.println("The book " + book.getTitle() + " has been borrowed.");
        } else {
            book.setAvailable(false);
            System.out.println("Book borrowed successfully.");
        }
    }

    // method to return a book to the library
    private static void returnBook() {
        clearScreen();
        // get book to be returned
        System.out.println("Enter the ID of the book to return: ");
        int id = input.nextInt();
        input.nextLine();

        Book book = library.findBook(id);

        // checks if book is available
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isAvailable()) {
            System.out.println("The book " + book.getTitle() + " is already in the library.");
        } else {
            book.setAvailable(true);
            System.out.println("Book returned successfully.");
        }
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
            input.nextLine();

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
}