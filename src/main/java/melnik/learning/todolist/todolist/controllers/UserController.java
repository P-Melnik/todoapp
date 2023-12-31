package melnik.learning.todolist.todolist.controllers;

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

    // Principal helps to retrieve user information in Spring Security
    @ModelAttribute("user")
    public User getUser(Principal principal) {
        return userRepository.findByEmail(principal.getName());
    }

    @GetMapping
    public String getUserPage(@ModelAttribute("user") User user) {
        return "user_page";
    }

    @GetMapping("/statistic")
    public String getStatistic(@ModelAttribute("user") User user) {
        return "user_statistic";
    }

}
