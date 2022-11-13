package com.example.finalproject.Repository;

import com.example.finalproject.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryDal extends JpaRepository<Category,Integer> {

    Category getByCategoryId(int id);
    Category getByCategoryName(String categoryName);
}
