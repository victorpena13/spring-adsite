package com.winter.adlist.controllers;

import com.winter.adlist.models.Category;
import com.winter.adlist.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {

    private final CategoryRepository categoryDao;

    public CategoryController(CategoryRepository cateogoryRepository) {
        categoryDao = cateogoryRepository;
    }


    @GetMapping("/categories/{id}")
    public String displayCategories(@PathVariable long id, Model vModel) {
        Category categoryId = categoryDao.findOne(id);
        Iterable<Category> categories=categoryDao.findAll();
        vModel.addAttribute("category", categoryId);
        vModel.addAttribute("categories", categories);
        return "index";
    }
}
