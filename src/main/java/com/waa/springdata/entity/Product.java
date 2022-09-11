package com.waa.springdata.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private double rating;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    // don't serialize the category property
    // i.e we will not see the category field
    //@JsonBackReference // prevent circular serialization
    // we can also use @JsonIgnore to get the same effect
    @JsonManagedReference
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 1)
    private Category category;

}
