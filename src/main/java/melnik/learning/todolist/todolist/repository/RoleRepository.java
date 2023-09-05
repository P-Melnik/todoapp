package melnik.learning.todolist.todolist.repository;

import melnik.learning.todolist.todolist.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
