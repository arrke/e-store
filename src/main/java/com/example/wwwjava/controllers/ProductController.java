package com.example.wwwjava.controllers;

import com.example.wwwjava.models.ProductDTO;
import com.example.wwwjava.services.categories.CategoryService;
import com.example.wwwjava.services.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ProductController {
    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/products")
    public String allProducts(Model model){
        model.addAttribute("listProducts", productService.getAllProducts());
        logger.info("get all products method in use");
        return "products/index";
    }

    @GetMapping("/products/new")
    public String addProduct(Model model){
        ProductDTO product = new ProductDTO();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("method", "POST");
        logger.info("product added");
        return "products/form";
    }

    @PostMapping("/products")
    public String saveProduct(@Valid @ModelAttribute("product") ProductDTO product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("categories", categoryService.getAllCategories());
            model.addAttribute("method", "POST");
            logger.error("cannot save product. Error in saveProduct method");
            return "products/form";
        }
        productService.saveProduct(product);
        logger.info("saved product");
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable(value="id") Long id, Model model){
        ProductDTO product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("method", "PUT");
        model.addAttribute("categories", categoryService.getAllCategories());
        logger.info("product edited");
        return "products/form";
    }

    @PutMapping("/products")
    public String updateProduct(@Valid @ModelAttribute("product") ProductDTO product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("categories", categoryService.getAllCategories());
            model.addAttribute("method", "PUT");
            logger.error("product cannot be updated");

            return "products/form";
        }
        productService.saveProduct(product);
        logger.info("product saved in updateProduct");

        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable(value="id") Long id, Model model){
        productService.deleteProductById(id);
        logger.info("deleted product");
        return "redirect:/products";
    }

}
