package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;
import com.example.demo.user.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private List<User> userList = new ArrayList<>();
    @Autowired
private UserService userService;
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        // Aggiungi il nuovo utente alla lista degli utenti (in una situazione reale, salveresti nel database)
        userService.saveUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userList);
        return "user-list";
    }
    
}
