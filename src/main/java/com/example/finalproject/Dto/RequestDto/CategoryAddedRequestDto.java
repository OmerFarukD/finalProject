package com.example.finalproject.Dto.RequestDto;

import com.example.finalproject.Annotations.UniqueCategory.UniqueCategory;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CategoryAddedRequestDto {
    @UniqueCategory
    @NotNull
    @NotBlank
    private String categoryName;
}