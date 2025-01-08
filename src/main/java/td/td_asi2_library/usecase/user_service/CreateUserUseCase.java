package td.td_asi2_library.usecase.user_service;

import td.td_asi2_library.domain.entity.User;
import td.td_asi2_library.domain.repository_port.UserRepositoryPort;

public class CreateUserUseCase {
    private final UserRepositoryPort userRepository;

    public CreateUserUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(String email) {
        // Vérifier si l'utilisateur existe
        if (userRepository.findByEmail(email) != null) {
            throw new RuntimeException("User already exists with email " + email);
        }
        // Créer l'entité User
        User newUser = new User(email);
        // Sauvegarder via le port
        return userRepository.save(newUser);
    }
}
