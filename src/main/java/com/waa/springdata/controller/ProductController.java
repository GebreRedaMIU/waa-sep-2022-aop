package com.waa.springdata.controller;

import com.waa.springdata.dto.ProductDto;
import com.waa.springdata.entity.Product;
import com.waa.springdata.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService productService;
    HttpServletRequest request;
    public ProductController(ProductService productService,
                             HttpServletRequest request) {
        this.productService = productService;
        this.request =request;
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return this.productService.findAll();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return this.productService.findProductById(id);
    }


    @GetMapping("/filter")
    public List<Product> getProductByPriceAndRating(@RequestParam int price, @RequestParam double rating) {
        return this.productService.findByPriceAndRating(price, rating);
    }
    @GetMapping("/filter/price")
    public List<Product> getProductByMinPrice(@RequestParam int minPrice, @RequestParam int maxPrice) {
        return this.productService.findByMinAndMaxPrice(minPrice, maxPrice);
    }
    @GetMapping("/filter/category")
    public List<Product> findByCategoryNameAndLessThanPrice(@RequestParam String categoryName, @RequestParam int maxPrice) {
        return this.productService.findByCategoryNameAndLessThanPrice(categoryName, maxPrice);
    }
    @GetMapping("/filter/keyword")
    public List<Product> findByNameContaining(@RequestParam String keyword) {
        return this.productService.findByNameContaining(keyword);
    }
    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return this.productService.createProduct(product);
    }
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return this.productService.updateProduct(product);
    }
}
