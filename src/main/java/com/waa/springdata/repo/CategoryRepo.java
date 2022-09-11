package com.waa.springdata.repo;

import com.waa.springdata.entity.Category;
import com.waa.springdata.entity.Category;
import com.waa.springdata.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {

    List<Category> findAll();


    @Query(nativeQuery = true, value = "select * from product p " +
            "where p.category_id = ?1")
    List<Product> findAllProductsByCatId(int id);
}
