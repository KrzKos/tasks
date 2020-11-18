package pl.kostkiewicz.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kostkiewicz.tasks.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
