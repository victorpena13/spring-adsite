package com.winter.adlist.controllers;

import com.winter.adlist.models.User;
import com.winter.adlist.repositories.AdRepository;
import com.winter.adlist.repositories.CategoryRepository;
import com.winter.adlist.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    private final AdRepository adDao;
    private final UserRepository userDao;
    private PasswordEncoder passwordEncoder;
    private final CategoryRepository categoryDao;


    public AuthenticationController(AdRepository adRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, CategoryRepository categoryRepository) {
        adDao = adRepository;
        userDao = userRepository;
        this.passwordEncoder = passwordEncoder;
        categoryDao = categoryRepository;
    }
    @GetMapping("/login")
    public String showLoginForm(Model vModel) {
        vModel.addAttribute("alreadyExists", false);
        return "site/login";
    }

    //retrieves page for user to input new credentials
    @GetMapping("/register")
    public String registerPage(Model vModel){
        vModel.addAttribute("user", new User());
        return "site/register";
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
