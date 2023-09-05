package melnik.learning.todolist.todolist.repository;

import melnik.learning.todolist.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
