package com.winter.adlist.controllers;

import com.winter.adlist.models.Ad;

import com.winter.adlist.models.Category;
import com.winter.adlist.repositories.AdRepository;
import com.winter.adlist.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {


    private final CategoryRepository categoryDao;
    private final AdRepository adDao;

    public IndexController(CategoryRepository categoryRepository, AdRepository adRepository) {
        categoryDao = categoryRepository;
        adDao = adRepository;
    }

//returns homePage & pulls all categories from database
    @GetMapping(value = {"/"})
    public String homePage(Model vModel) {
        Iterable<Category> categories = categoryDao.findAll();
        vModel.addAttribute("categories", categories);
        return "index";
    }

//provides a path to the specific category and
//all ads that belong to said category
    @GetMapping("/categories/{id}")
    public String linkCategories(@PathVariable long id, Model vModel) {
        Category categoryId = categoryDao.findOne(id);
        Iterable<Ad> ads = adDao.findAllByCategoriesOrderByIdDesc(categoryId);
        vModel.addAttribute("category", categoryId);
        vModel.addAttribute("ads", ads);
        return "site/category";
    }



}



