package com.example.wwwjava.controllers;

import com.example.wwwjava.models.Category;
import com.example.wwwjava.services.categories.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CategoryController {
    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String index(Model model){
        model.addAttribute("categoryList", categoryService.getAllCategories());
        logger.info("show list od categories");
        return "categories/index";
    }

    @GetMapping("/categories/new")
    public String newCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("method", "POST");
        logger.info("category added");

        return "categories/form";
    }

    @PostMapping("/categories")
    public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("category", category);
            model.addAttribute("method", "POST");
            logger.error("error in saving category");
            return "categories/form";
        }
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String updateCategory(@PathVariable(value="id") Long id, Model model){
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("method", "PUT");
        logger.info("category update in get method");
        return "categories/form";
    }

    @PutMapping("/categories")
    public String updateCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("category", category);
            model.addAttribute("method", "PUT");
            logger.info("category updated in post method");

            return "categories/form";
        }
        categoryService.saveCategory(category);
        logger.info("category saved");

        return "redirect:/";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable(value="id") Long id, Model model){
        categoryService.deleteCategoryById(id);
        logger.info("category deleted");

        return "redirect:/categories";
    }
}
