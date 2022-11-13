package com.example.finalproject.Dto.RequestDto;

import com.example.finalproject.Annotations.UniqueCategory.UniqueCategory;
import lombok.Data;

@Data
public class CategoryUpdatedRequestDto{

    private int categoryId;

    @UniqueCategory
    private String categoryName;

}
