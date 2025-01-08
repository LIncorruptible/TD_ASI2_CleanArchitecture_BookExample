package td.td_asi2_library.usecase.user_service;

import td.td_asi2_library.domain.repository_port.UserRepositoryPort;

public class DeleteUserUseCase {
    private final UserRepositoryPort userRepository;

    public DeleteUserUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean execute(Long id) {
        // Vérifier si l'utilisateur existe
        if (userRepository.findById(id) == null) {
            throw new RuntimeException("User not found with ID " + id);
        }
        // Supprimer via le port
        return userRepository.delete(id);
    }
}
