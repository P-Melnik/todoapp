package melnik.learning.todolist.todolist.controllers;

import melnik.learning.todolist.todolist.entity.Todo;
import melnik.learning.todolist.todolist.entity.User;
import melnik.learning.todolist.todolist.repository.TodoRepository;
import melnik.learning.todolist.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;


    @ModelAttribute("user")
    public User getUser(Principal principal) {
        return userRepository.findByEmail(principal.getName());
    }

//    @ModelAttribute("todo")
//    public Todo getTodoList() {
//        return new Todo();
//    }

    @GetMapping()
    public String getTodos(@ModelAttribute("user") User user,
                           Model model) {
        model.addAttribute("todo",
                todoRepository.findAllByUserId(user.getId()));
        return "user_todos";
    }

    @GetMapping("/create")
    public String getCreateTodo(@ModelAttribute("user") User user,
                                @ModelAttribute("todo") Todo todo) {
        return "user_todo_create";
    }

    @PostMapping("/create")
    public String saveTodo(@ModelAttribute("user") User user,
                           @ModelAttribute("todo") Todo todo) {
        todo.setUser_id(user);
        todoRepository.save(todo);
        return "redirect:/user/todo";
    }

}
