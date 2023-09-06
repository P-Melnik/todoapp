package melnik.learning.todolist.todolist.controllers;

import melnik.learning.todolist.todolist.dto.RegistrationDTO;
import melnik.learning.todolist.todolist.entity.User;
import melnik.learning.todolist.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("user")
    public User registrationDTO(Principal principal) {
        System.out.println("getName: " + principal.getName());
        return userRepository.findByEmail(principal.getName());
    }

    @GetMapping
    public String hetUserPage(@ModelAttribute("user") User user) {

        return "user_page";
    }

}
