package com.example.finalproject.Dto.RequestDto;

import com.example.finalproject.Annotations.UniqueProduct.UniqueProduct;
import lombok.Data;

@Data
public class ProductUpdatedRequestDto {

    private int productId;

    private int categoryId;

    @UniqueProduct
    private String productName;

    private double unitPrice;

    private int unitsInStock;
}
