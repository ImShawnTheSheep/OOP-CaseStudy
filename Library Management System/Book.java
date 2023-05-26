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