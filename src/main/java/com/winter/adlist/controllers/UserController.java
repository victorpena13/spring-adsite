package com.winter.adlist.controllers;

import com.winter.adlist.models.Ad;
import com.winter.adlist.models.Category;
import com.winter.adlist.models.User;
import com.winter.adlist.repositories.AdRepository;
import com.winter.adlist.repositories.CategoryRepository;
import com.winter.adlist.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final AdRepository adDao;
    private final UserRepository userDao;
    private PasswordEncoder passwordEncoder;
    private final CategoryRepository categoryDao;


    public UserController(AdRepository adRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, CategoryRepository categoryRepository) {
        adDao = adRepository;
        userDao = userRepository;
        this.passwordEncoder = passwordEncoder;
        categoryDao = categoryRepository;
    }



    @GetMapping("/profile")
    public String getUserProfile(Model vModel) {
        User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userDao.findOne(userSession.getId());
        Iterable<Category> categories = categoryDao.findAll();
        vModel.addAttribute("categories", categories);
        vModel.addAttribute("ads", new Ad());
        vModel.addAttribute("user", currentUser);
        Iterable<Ad> userAds = adDao.findByOwner(userSession);
        vModel.addAttribute("userAds", userAds);
        return "user/profile";
    }


    //provides users a category to place the ad they are about to create
    @GetMapping("/ads/create")
    public String createAdForm(Model vModel) {
        Iterable<Category> categories = categoryDao.findAll();
        vModel.addAttribute("categories", categories);
        vModel.addAttribute("posts", new Ad());
        return "user/createAd";
    }




}
