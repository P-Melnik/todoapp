package melnik.learning.todolist.todolist.repository;

import melnik.learning.todolist.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

//    @Query(value = "select * from todos where ")
//    List<Todo> findAllByUserId(Long id);
}
