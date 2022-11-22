package com.example.finalproject.Annotations.OrderBusinesRules;


import com.example.finalproject.Dto.RequestDto.OrderAddedRequestDto;
import com.example.finalproject.Entity.Product;
import com.example.finalproject.Repository.IProductDal;
import lombok.RequiredArgsConstructor;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class OrderBusinessRuleValidator implements ConstraintValidator<OrderBusinessRule, OrderAddedRequestDto> {

    private final IProductDal productDal;


    @Override
    public boolean isValid(OrderAddedRequestDto value, ConstraintValidatorContext context) {

        Product product=this.productDal.getById(value.getProductId());
        return product.getUnitsInStock() >= value.getPiece();
    }

}
