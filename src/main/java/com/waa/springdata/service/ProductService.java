package com.waa.springdata.service;

import com.waa.springdata.aop.annotation.ExecutionTime;
import com.waa.springdata.aop.annotation.LogThis;
import com.waa.springdata.dto.ProductDto;
import com.waa.springdata.entity.Category;
import com.waa.springdata.entity.Product;
import com.waa.springdata.repo.ProductRepo;
import com.waa.springdata.service.interfaces.ProductInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ProductService implements ProductInterface {

    private ProductRepo productRepo;
    private ModelMapper modelMapper;

    public ProductService(ProductRepo productRepo, ModelMapper modelMapper) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(Product p) {
        productRepo.save(p);
    }

    @Override
    public List<Product> findByPrice(int price) {
        return productRepo.findAllByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findByPriceGreaterThan(int minPrice) {
        return productRepo.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findByPriceAndRating(int price, double rating) {
        return productRepo.findByPriceAndRating(price, rating);
    }

    @Override
    public List<Product> findByMinAndMaxPrice(int minPrice, int maxPrice) {
        return productRepo.findAllByPriceGreaterThanEqualAndPriceLessThanEqual(minPrice, maxPrice);
    }

    @Override
    public List<Product> findByCategoryNameAndLessThanPrice(String categoryName, int maxPrice) {
        return productRepo.findByCategoryNameAndPriceLessThan(categoryName,maxPrice);
    }

    @Override
    public List<Product> findByNameContaining(String keyword) {
        return productRepo.findByNameContaining(keyword);
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
    @LogThis
    @ExecutionTime
    public List<ProductDto> findAll() {
        List<Product> productEntities = productRepo.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
         productEntities.stream()
                .map(pe ->productDtos.add(modelMapper.map(pe, ProductDto.class)))
                .collect(Collectors.toList());
        return productDtos;
    }

    public Product findProductById(int id) {
        return productRepo.findById(id).orElseGet(null);
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }
    public void deleteProduct(int id) {
       Optional<Product> product = productRepo.findById(id);
       if (product.isPresent())
           productRepo.delete(product.orElseGet(null));
    }


}
