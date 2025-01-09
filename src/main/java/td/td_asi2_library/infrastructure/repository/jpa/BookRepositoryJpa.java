package td.td_asi2_library.infrastructure.repository.jpa;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import td.td_asi2_library.infrastructure.entity.BookJpa;

import java.util.List;

@Repository
public interface BookRepositoryJpa extends JpaRepository<BookJpa, Long> {

    // From Port
    @Modifying
    @Transactional
    @Query("DELETE FROM BookJpa b WHERE b.isbn = :isbn")
    void deleteByIsbn(@Param("isbn") String isbn);

    @Query("SELECT b FROM BookJpa b WHERE b.isbn = :isbn")
    BookJpa getByIsbn(@Param("isbn") String isbn);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN TRUE ELSE FALSE END FROM BookJpa b WHERE b.isbn = :isbn")
    boolean existingByIsbn(@Param("isbn") String isbn);

    @Query("SELECT b FROM BookJpa b")
    List<BookJpa> getAll();

    // From Custom
    @Query("SELECT b FROM BookJpa b WHERE b.id = :id")
    BookJpa getById(@Param("id") String id);
}
