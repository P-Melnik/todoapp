package melnik.learning.todolist.todolist.repository;

import melnik.learning.todolist.todolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
