package pl.kostkiewicz.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kostkiewicz.tasks.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
