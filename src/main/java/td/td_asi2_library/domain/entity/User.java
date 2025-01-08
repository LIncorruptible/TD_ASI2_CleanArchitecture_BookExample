package td.td_asi2_library.domain.entity;

public class User {

    // Attributs
    private Long id;
    private String name;

    // Constructeurs
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters/Setters
    public Long getId() { return id; }
    public String getName() { return name; }
}