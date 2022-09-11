package com.waa.springdata.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class ReviewDto {
    private int id;
    private String comment;
    private UserDto user;
}
