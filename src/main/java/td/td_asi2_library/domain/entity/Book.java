package td.td_asi2_library.domain.entity;

public class Book {
    // Attributes
    private String isbn;
    private String metadata;
    private String file;

    // Constructor no-args
    public Book() {}

    // Constructor with args
    public Book(
        String isbn,
        String metadata,
        String file
    ) {
        this.isbn = isbn;
        this.metadata = metadata;
        this.file = file;
    }

    // Getters
    public String getIsbn() { return isbn; }
    public String getMetadata() { return metadata; }
    public String getFile() { return file; }

    // Setters
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setMetadata(String metadata) { this.metadata = metadata; }
    public void setFile(String file) { this.file = file; }

    // Validation
    public boolean isValid() {
        if (!hasIsbn()) throw new IllegalArgumentException("ISBN is required");
        if (!hasMetadata()) throw new IllegalArgumentException("Metadata is required");
        if (!hasFile()) throw new IllegalArgumentException("File is required");
        return true;
    }

    // Controls
    private boolean hasIsbn() { return isbn != null; }
    private boolean hasMetadata() { return metadata != null; }
    private boolean hasFile() { return file != null; }
}
