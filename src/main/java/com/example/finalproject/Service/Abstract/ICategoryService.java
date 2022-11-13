package com.example.finalproject.Service.Abstract;

import com.example.finalproject.Core.Result.DataResult;
import com.example.finalproject.Core.Result.Result;
import com.example.finalproject.Dto.RequestDto.CategoryAddedRequestDto;
import com.example.finalproject.Dto.RequestDto.CategoryUpdatedRequestDto;
import com.example.finalproject.Dto.ResponseDto.CategoryResponseDto;

import java.util.List;

public interface ICategoryService {

    Result add(CategoryAddedRequestDto requestDto);
    DataResult<List<CategoryResponseDto>> getAll();
    DataResult<CategoryResponseDto> getByCategoryId(int id);
    Result deleteById(int id);
    Result update(CategoryUpdatedRequestDto categoryUpdatedRequestDto);
}
