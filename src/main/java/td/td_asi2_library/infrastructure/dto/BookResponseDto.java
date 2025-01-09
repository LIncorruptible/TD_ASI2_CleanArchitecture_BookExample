package td.td_asi2_library.infrastructure.dto;

public class BookResponseDto {
    private String isbn;
    private String metadata;
    private String file;

    public BookResponseDto(String isbn, String metadata, String file) {
        this.isbn = isbn;
        this.metadata = metadata;
        this.file = file;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getMetadata() {
        return metadata;
    }

    public String getFile() {
        return file;
    }
}