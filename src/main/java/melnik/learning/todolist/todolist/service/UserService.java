package melnik.learning.todolist.todolist.service;

import melnik.learning.todolist.todolist.dto.RegistrationDTO;
import melnik.learning.todolist.todolist.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(RegistrationDTO registrationDTO);
}
