package melnik.learning.todolist.todolist.controllers;

import melnik.learning.todolist.todolist.dto.UserDTO;
import melnik.learning.todolist.todolist.entity.User;
import melnik.learning.todolist.todolist.entity.tutor;
import melnik.learning.todolist.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getStartingPage() {
        return "starting_page";
    }

    @GetMapping(value = "/about")
    public String getAbout() {
        return "about";
    }

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

    @PostMapping("/login")
    public String getUserPage() {
        return "user_page";
    }

    @GetMapping(value = "/greet")
    public String greet(Model model) {
        model.addAttribute("something", "text from thymeleaf");
        model.addAttribute("tutor", Arrays.asList(
                new tutor(1, "a"),
                new tutor(2, "b"),
                new tutor(3, "c")
        ));
        return "greet";
    }


}
