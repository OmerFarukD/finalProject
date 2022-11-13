package com.example.finalproject.Annotations.UniqueCategory;

import com.example.finalproject.Entity.Category;
import com.example.finalproject.Repository.ICategoryDal;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCategoryValidator implements ConstraintValidator<UniqueCategory,String> {

    @Autowired
    private ICategoryDal categoryDal;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Category category=this.categoryDal.getByCategoryName(value);
        return category == null;
    }
}