package web.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.spring_boot.model.User;
import web.spring_boot.service.UserService;


@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/allUsers")
    public String getUsers(Model model) {
        model.addAttribute("usersList", userService.getUsers());
        return "users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model){
        model.addAttribute("user", new User());
        return "user-info";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveOrChangeUser(user);
        return "redirect:/allUsers";
    }
    @RequestMapping("/updateInfo/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-info";
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/allUsers";
    }
}
