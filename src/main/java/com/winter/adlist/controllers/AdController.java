package com.winter.adlist.controllers;

import com.winter.adlist.models.Ad;

import com.winter.adlist.models.Category;
import com.winter.adlist.repositories.AdRepository;
import com.winter.adlist.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;;

import javax.servlet.annotation.WebServlet;

@Controller
public class AdController {

    private final CategoryRepository categoryDao;
    private final AdRepository adDao;

    public AdController(CategoryRepository categoryRepository, AdRepository adRepository) {
        categoryDao = categoryRepository;
        adDao = adRepository;
    }

//creates path for categories to display corresponding posts
    @GetMapping("/ads/{id}")
    public String showPosts(@PathVariable long id, Model vModel) {
        Category categoryId = categoryDao.findOne(id);
        Iterable <Ad> ads = adDao.findAllByCategoriesOrderByIdDesc(categoryId);
        vModel.addAttribute("category", categoryId);
        vModel.addAttribute("ads", ads);
        return "site/category";
    }
}
