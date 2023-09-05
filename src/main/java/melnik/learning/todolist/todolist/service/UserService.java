package melnik.learning.todolist.todolist.service;

import melnik.learning.todolist.todolist.dto.UserDTO;
import melnik.learning.todolist.todolist.entity.User;
import melnik.learning.todolist.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserDTO userDTO) {
        User user = new User(userDTO.getFirstName(), userDTO.getLastName(),
                userDTO.getUserName(), userDTO.getEmail(), userDTO.getPassword());
        userRepository.save(user);
    }

    public UserDTO convertEntityToDto(User user){
        UserDTO userDto = new UserDTO();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
