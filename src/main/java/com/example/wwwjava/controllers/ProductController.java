package com.example.wwwjava.controllers;

import com.example.wwwjava.models.Category;
import com.example.wwwjava.models.ProductDTO;
import com.example.wwwjava.services.CategoryService;
import com.example.wwwjava.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/")
    public String allProducts(Model model){
        model.addAttribute("listProducts", productService.getAllProducts());
        return "products/index";
    }

    @GetMapping("/products/new")
    public String addProduct(Model model){
        ProductDTO product = new ProductDTO();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("method", "POST");
        return "products/form";
    }

    @PostMapping("/products")
    public String saveProduct(@Valid @ModelAttribute("product") ProductDTO product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("categories", categoryService.getAllCategories());
            model.addAttribute("method", "POST");
            return "products/form";
        }
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable(value="id") Long id, Model model){
        ProductDTO product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("method", "PUT");
        model.addAttribute("categories", categoryService.getAllCategories());
        return "products/form";
    }

    @PutMapping("/products")
    public String updateProduct(@Valid @ModelAttribute("product") ProductDTO product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("categories", categoryService.getAllCategories());
            model.addAttribute("method", "PUT");
            return "products/form";
        }
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable(value="id") Long id, Model model){
        productService.deleteProductById(id);
        return "redirect:/";
    }

}
