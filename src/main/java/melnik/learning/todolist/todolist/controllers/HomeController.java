package melnik.learning.todolist.todolist.controllers;

import melnik.learning.todolist.todolist.entity.tutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping()
    public String getStartingPage() {
        return "starting_page";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @GetMapping("/greet")
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
