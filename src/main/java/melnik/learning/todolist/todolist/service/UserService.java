package melnik.learning.todolist.todolist.service;

import melnik.learning.todolist.todolist.dto.UserDTO;
import melnik.learning.todolist.todolist.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void saveUser(UserDTO userDto);

    User findByEmail(String email);
}
