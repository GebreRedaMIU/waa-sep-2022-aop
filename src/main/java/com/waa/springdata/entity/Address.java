package com.waa.springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Address {
    @Id
    private int id;
    private String street;
    private String zip;
    private String city;
    @OneToOne
    @JsonIgnore // or @JSONBackReference
    private User user;

}

