package com.waa.springdata.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Review {

    @Id
    private int id;
    private String comment;
    @ManyToOne
    private User user;
}
