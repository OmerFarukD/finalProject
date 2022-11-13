package com.example.finalproject.Dto.ResponseDto;

import lombok.Data;

@Data
public class ProductResponseDto {
    private String productName;

    private double unitPrice;

    private int unitsInStock;

    private String categoryName;

}
