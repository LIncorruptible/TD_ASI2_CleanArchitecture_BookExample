package td.td_asi2_library.domain.repository_port;

import td.td_asi2_library.domain.entity.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(Long id);
}