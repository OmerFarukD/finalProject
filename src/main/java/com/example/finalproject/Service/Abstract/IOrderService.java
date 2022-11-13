package com.example.finalproject.Service.Abstract;

import com.example.finalproject.Core.Result.DataResult;
import com.example.finalproject.Core.Result.Result;
import com.example.finalproject.Dto.RequestDto.OrderAddedRequestDto;
import com.example.finalproject.Dto.RequestDto.OrderUpdatedRequestDto;
import com.example.finalproject.Dto.ResponseDto.OrderResponseDto;
import com.example.finalproject.Entity.Order;
import com.example.finalproject.Entity.Product;

import java.util.List;

public interface IOrderService {
    Result add(OrderAddedRequestDto orderAddedRequestDto);
    DataResult<List<OrderResponseDto>> getAllOrders();
    Result deleteById(int id);
    Result updateOrder(OrderUpdatedRequestDto orderUpdatedRequestDto);
}
