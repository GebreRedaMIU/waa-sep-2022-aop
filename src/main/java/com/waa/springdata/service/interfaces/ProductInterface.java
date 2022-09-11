package com.waa.springdata.service.interfaces;


import com.waa.springdata.entity.Product;

import java.util.List;

public interface ProductInterface {

    void save(Product p);

    List<Product> findByPrice(int price);
    List<Product> findByPriceGreaterThan(int minPrice);
    List<Product> findByPriceAndRating(int price, double rating);
    public List<Product> findByMinAndMaxPrice(int minPrice, int maxPrice);
    public List<Product> findByCategoryNameAndLessThanPrice(String categoryName, int maxPrice);
    public List<Product> findByNameContaining(String keyword);



}
