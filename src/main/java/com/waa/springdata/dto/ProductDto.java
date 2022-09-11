package com.waa.springdata.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private int price;
    private double rating;
    private CategoryDto category;

}
