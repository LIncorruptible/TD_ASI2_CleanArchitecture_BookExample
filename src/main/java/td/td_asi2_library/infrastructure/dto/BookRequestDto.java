package td.td_asi2_library.infrastructure.dto;

public class BookRequestDto {
    private String isbn;
    private String metadata;
    private String file;

    public BookRequestDto() {}

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