package com.example.finalproject.Dto.RequestDto;


import com.example.finalproject.Annotations.UniqueProduct.UniqueProduct;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductAddedRequestDto {

    @UniqueProduct
    @NotNull
    @NotBlank
    private String productName;

    @NotNull
    @Min(0)
    private int unitsInStock;

    @Min(0)
    private double unitPrice;

    @NotNull
    private int categoryId;

}
