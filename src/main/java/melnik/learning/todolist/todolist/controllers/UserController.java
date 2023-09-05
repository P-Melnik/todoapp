package melnik.learning.todolist.todolist.controllers;

import melnik.learning.todolist.todolist.dto.UserDTO;
import melnik.learning.todolist.todolist.entity.User;
import melnik.learning.todolist.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String getSignUp(Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup/save")
    public String submitSignUp(@ModelAttribute("user") UserDTO user,
                               Model model,
                               BindingResult bindingResult) {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            bindingResult.rejectValue("email",
                    null,
                    "There is already an account registered with that email");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "signup";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping(value = "/login")
    public String getLogin() {
        return "login";
    }

    // implement after login logic

}
