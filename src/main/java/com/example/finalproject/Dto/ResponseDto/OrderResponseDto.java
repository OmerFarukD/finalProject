package com.example.finalproject.Dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private double total;
    private int piece;
    private ProductResponseDto productResponseDto;


}
