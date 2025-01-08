package td.td_asi2_library.domain.repository_port;

import td.td_asi2_library.domain.entity.User;

import java.util.List;

public interface UserRepositoryPort {
    User save(User user);
    Boolean delete(Long id);
    User findById(Long id);
    User findByEmail(String email);
    List<User> findAll();
}