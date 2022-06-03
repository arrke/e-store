package com.example.wwwjava.controllers;

import com.example.wwwjava.models.Category;
import com.example.wwwjava.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CategoryController {
    @Autowired
    private CategoryDao categoryService;

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
    public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("category", category);
            model.addAttribute("method", "POST");
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
        return "categories/form";
    }

    @PutMapping("/categories")
    public String updateCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("category", category);
            model.addAttribute("method", "PUT");
            return "categories/form";
        }
        categoryService.saveCategory(category);
        return "redirect:/";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable(value="id") Long id, Model model){
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }
}
