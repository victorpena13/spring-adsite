package com.winter.adlist.controllers;

import com.winter.adlist.models.User;
import com.winter.adlist.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        userDao = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    //Gets the userinput
    @GetMapping("/register")
    public String registerPage(Model vModel){
        vModel.addAttribute("user", new User());
        return "user/register";
    }

    //Posts the user input into mysql database;
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user, Model vModel) {
        vModel.addAttribute("alreadyExists", false);

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        if (user.getPhoto().equalsIgnoreCase("")){
            user.setPhoto(null);
        }
        if (userDao.findUserByEmail(user.getEmail()) != null){
            vModel.addAttribute("alreadyExists", false);
            return "redirect:/login";
        }
        if (userDao.findByUsername(user.getUsername()) != null){
            vModel.addAttribute("alreadyExists", true);
            return "redirect:/login";
        }
        userDao.save(user);
        return "redirect:/login";
    }




}
