package melnik.learning.todolist.todolist.repository;

import jakarta.transaction.Transactional;
import melnik.learning.todolist.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query(value = "select * from todos where user_id = :id",
    nativeQuery = true)
    List<Todo> findAllByUserId(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "update todos set description = :desc where id = :id",
            nativeQuery = true)
    void edit(@Param("id") long id, @Param("desc") String desc);
}
