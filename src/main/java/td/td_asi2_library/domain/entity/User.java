package td.td_asi2_library.domain.entity;

public class User {

    // Attributs
    private Long id;
    private String email;

    // Constructeurs

    public User(String email) {
        this.email = email;
    }

    public User(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    // Getters/Setters
    public Long getId() { return id; }
    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}