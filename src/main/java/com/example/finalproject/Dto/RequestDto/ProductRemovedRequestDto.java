package com.example.finalproject.Dto.RequestDto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ProductRemovedRequestDto {
    @NotNull
    @Min(0)
    private int id;
}
