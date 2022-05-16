package com.example.wwwjava.controllers;

import com.example.wwwjava.models.Category;
import com.example.wwwjava.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String index(Model model){
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "categories/index";
    }

    @GetMapping("/categories/new")
    public String newCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("method", "POST");
        return "categories/form";
    }

    @PostMapping("/categories")
    public String saveCategory(@ModelAttribute("category") Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String updateCategory(@PathVariable(value="id") Long id, Model model){
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("method", "PUT");
        return "categories/form";
    }

    @PutMapping("/categories")
    public String updateCategory(@ModelAttribute("category") Category category){
        categoryService.saveCategory(category);
        return "redirect:/";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable(value="id") Long id, Model model){
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }
}
