package com.waa.springdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @JsonIgnore // prevent circular fetch
    private List<ReviewDto> reviews;
    private AddressDto address;
}

