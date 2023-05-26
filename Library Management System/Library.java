import java.util.ArrayList;
import java.util.List;

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
            if (book.getID() == id)
                return book;
        }
        return null;
    }

    // method to get all available books in the library
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.isAvailable())
                availableBooks.add(book);
        }
        return availableBooks;
    }

    // method to check if a book exists in the library
    public boolean containsBook(String title, String author) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author))
                return true;
        }
        return false;
    }
}
