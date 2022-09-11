package com.waa.springdata.service.interfaces;


import com.waa.springdata.entity.Category;
import com.waa.springdata.entity.Category;

import java.util.List;

public interface CategoryInterface {

    void save(Category category);
    List<Category> findByName(String name);

}
