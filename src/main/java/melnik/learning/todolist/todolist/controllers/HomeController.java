package melnik.learning.todolist.todolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

}
