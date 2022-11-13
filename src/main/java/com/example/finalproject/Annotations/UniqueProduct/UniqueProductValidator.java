package com.example.finalproject.Annotations.UniqueProduct;

import com.example.finalproject.Entity.Product;
import com.example.finalproject.Repository.IProductDal;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueProductValidator implements ConstraintValidator<UniqueProduct,String> {

    @Autowired
    private IProductDal productDal;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Product product=this.productDal.getByProductName(value);
        return product==null;
    }
}