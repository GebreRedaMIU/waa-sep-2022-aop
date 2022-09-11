package com.waa.springdata.controller;

import com.waa.springdata.dto.CategoryDto;
import com.waa.springdata.dto.ProductDto;
import com.waa.springdata.entity.Category;
import com.waa.springdata.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    @GetMapping
    public List<CategoryDto> getCategories() {
        return this.categoryService.findAll();
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return this.categoryService.findCategoryById(id);
    }
    @GetMapping("/{id}/products")
    public List<ProductDto> getProductsByCategoryId(@PathVariable int id) {
        return this.categoryService.findProductsByCategoryId(id);
    }
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return this.categoryService.createCategory(category);
    }
    @PutMapping
    public Category updateCategory(@RequestBody Category category) {
        return this.categoryService.updateCategory(category);
    }
}
