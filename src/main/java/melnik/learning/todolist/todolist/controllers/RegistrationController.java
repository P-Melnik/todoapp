package melnik.learning.todolist.todolist.controllers;

import melnik.learning.todolist.todolist.dto.RegistrationDTO;
import melnik.learning.todolist.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public RegistrationDTO registrationDTO() {
        return new RegistrationDTO();
    }

    @GetMapping
    public String getSignUp(Model model) {
        return "signup";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") RegistrationDTO registrationDTO) {
        userService.save(registrationDTO);
        return "redirect:/registration?success";
    }
}
