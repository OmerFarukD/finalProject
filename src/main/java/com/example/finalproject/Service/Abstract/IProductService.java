package com.example.finalproject.Service.Abstract;

import com.example.finalproject.Core.Result.DataResult;
import com.example.finalproject.Core.Result.Result;
import com.example.finalproject.Dto.RequestDto.ProductAddedRequestDto;
import com.example.finalproject.Dto.RequestDto.ProductRemovedRequestDto;
import com.example.finalproject.Dto.RequestDto.ProductUpdatedRequestDto;
import com.example.finalproject.Dto.ResponseDto.ProductResponseDto;

import java.util.List;

public interface IProductService {
    Result add(ProductAddedRequestDto requestDto);
    DataResult<List<ProductResponseDto>> getAll();
    Result delete(ProductRemovedRequestDto removedRequestDto);
    DataResult<List<ProductResponseDto>> getAllProductsByOrderId(int orderId);
    DataResult<ProductResponseDto> getById(int id);
    DataResult<List<ProductResponseDto>> getAllByCategoryId(int categoryId);
    Result update(ProductUpdatedRequestDto productUpdatedRequestDto);
}
