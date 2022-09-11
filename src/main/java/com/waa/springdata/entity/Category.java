package com.waa.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {
    @Id
    private int id;
    private String name;
    // the next relation can create circular r/n - stack overflow
    @OneToMany(mappedBy = "category")
    //@JsonManagedReference // serialize this property i.e this is forward relation
    @JsonBackReference
    private List<Product> products;

}
