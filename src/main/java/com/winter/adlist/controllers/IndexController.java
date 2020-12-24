package com.winter.adlist.controllers;

import com.winter.adlist.models.Category;
import com.winter.adlist.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final CategoryRepository categoryDao;

    public IndexController(CategoryRepository cateogoryRepository) {
        categoryDao = cateogoryRepository;
    }

//returns homePage & pulls categories from database
    @GetMapping(value = {"/"})
    public String homePage(Model vModel) {
        Iterable<Category> categories = categoryDao.findAll();
        vModel.addAttribute("categories", categories);
        return "index";
    }

}



