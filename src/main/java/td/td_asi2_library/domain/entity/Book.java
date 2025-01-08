package td.td_asi2_library.domain.entity;

public class Book {

    // Attributs
    private String isbn;
    private String title;
    private boolean isBorrowed;
    
    // Constructeurs
    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.isBorrowed = false;
    }

    // Getters/Setters
    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isBorrowed() { return isBorrowed; }

    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitle(String title) { this.title = title; }
    public void borrow() { this.isBorrowed = true; }
    public void returnBook() { this.isBorrowed = false; }
}