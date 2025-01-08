package td.td_asi2_library.usecase.user_service;

import td.td_asi2_library.domain.entity.User;
import td.td_asi2_library.domain.repository_port.UserRepositoryPort;

import java.util.List;

public class ListUserUseCase {
    private final UserRepositoryPort userRepository;

    public ListUserUseCase(UserRepositoryPort userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> execute() {
        return userRepository.findAll();
    }
}
