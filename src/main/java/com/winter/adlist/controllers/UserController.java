package com.winter.adlist.controllers;

import com.winter.adlist.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String signUp(Model vModel){
        vModel.addAttribute("user", new User());
        return "user/register";
    }


}
