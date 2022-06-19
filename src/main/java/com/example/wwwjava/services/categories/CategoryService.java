package com.example.wwwjava.services.categories;

import com.example.wwwjava.models.Category;

import java.util.List;

public interface CategoryService {
    public Category getCategoryById(Long id);
    public List<Category> getAllCategories();
    public void deleteCategoryById(Long id);
    public Category saveCategory(Category category);
}
