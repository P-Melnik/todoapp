package melnik.learning.todolist.todolist.controllers;

import melnik.learning.todolist.todolist.entity.tutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String getStartingPage() {
        return "starting_page";
    }

    @GetMapping(value = "/about")
    public String getAbout() {
        return "about";
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
