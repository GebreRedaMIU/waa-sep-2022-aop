package com.waa.springdata.service;

import com.waa.springdata.dto.CategoryDto;
import com.waa.springdata.dto.ProductDto;
import com.waa.springdata.entity.Category;
import com.waa.springdata.entity.Category;
import com.waa.springdata.entity.Product;
import com.waa.springdata.repo.CategoryRepo;
import com.waa.springdata.service.interfaces.CategoryInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CategoryService implements CategoryInterface {

    private CategoryRepo categoryRepo;
    private ModelMapper modelMapper;

    public CategoryService(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public List<Category> findByName(String name) {
        return null;
    }

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }
    public List<CategoryDto> findAll() {
        List<Category> categoryEntities = categoryRepo.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categoryEntities.stream()
                .map(ce ->categoryDtos.add(modelMapper.map(ce, CategoryDto.class)))
                .collect(Collectors.toList());
        return categoryDtos;
    }

    public Category findCategoryById(int id) {
        return categoryRepo.findById(id).orElseGet(null);
    }

    public Category updateCategory(Category category) {
        return categoryRepo.save(category);
    }

    public void deleteCategory(int id) {
       Optional<Category> category = categoryRepo.findById(id);
       if (category.isPresent())
           categoryRepo.delete(category.orElseGet(null));
    }

    public List<ProductDto> findProductsByCategoryId(int id) {
        List<ProductDto> productDtos = new ArrayList<>();
        Product p = new Product();
        p.setId(id);
        System.out.println(categoryRepo.findAllProductsByCatId(id));
        List<Product> fetched =  categoryRepo.findAllProductsByCatId(id);

        fetched  .stream()
                .map(pe -> modelMapper.map(pe, ProductDto.class))
                .collect(Collectors.toList());
        return productDtos;
    }
}
