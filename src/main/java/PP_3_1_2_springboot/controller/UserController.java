package PP_3_1_2_springboot.controller;

import PP_3_1_2_springboot.model.User;
import PP_3_1_2_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/pagesCrud")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String displayAll(Model model) {
        model.addAttribute("users", userService.getAll());
        return "pagesCrud/displayAll";
    }

    @GetMapping("/{id}")
    public String displayUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "pagesCrud/displayUser";
    }

    @GetMapping("/add")
    public String newUser(@ModelAttribute("user") User user) {
        return "pagesCrud/add";
    }

    @PostMapping()
    public String add(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/pagesCrud";
    }

    @GetMapping("/{id}/update")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "pagesCrud/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/pagesCrud";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/pagesCrud";
    }
}

