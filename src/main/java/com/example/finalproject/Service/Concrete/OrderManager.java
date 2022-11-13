package com.example.finalproject.Service.Concrete;

import com.example.finalproject.Core.Result.DataResult;
import com.example.finalproject.Core.Result.Result;
import com.example.finalproject.Core.Result.SuccessDataResult;
import com.example.finalproject.Core.Result.SuccessResult;
import com.example.finalproject.Dto.RequestDto.OrderAddedRequestDto;
import com.example.finalproject.Dto.RequestDto.OrderUpdatedRequestDto;
import com.example.finalproject.Dto.ResponseDto.OrderResponseDto;
import com.example.finalproject.Dto.ResponseDto.ProductResponseDto;
import com.example.finalproject.Entity.Order;
import com.example.finalproject.Repository.IOrderRepository;
import com.example.finalproject.Service.Abstract.IOrderService;
import com.example.finalproject.Service.Abstract.IProductService;
import com.example.finalproject.Service.Constants.Messages;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderManager implements IOrderService {

    private final IOrderRepository orderRepository;

    private final IProductService productService;

    @Override
    public Result add(OrderAddedRequestDto orderAddedRequestDto) {

        var data = this.productService.getById(orderAddedRequestDto.getProductId());
        if (!data.getSuccess()) {
            return data;
        }
        Order order =new Order();
        order.setProductId(orderAddedRequestDto.getProductId());
        order.setPiece(orderAddedRequestDto.getPiece());
        double total=(data.getData().getUnitPrice()*orderAddedRequestDto.getPiece());
        order.setTotal(total);
        this.orderRepository.save(order);
        return new SuccessResult(Messages.OrderAddedMessage);
    }

    @Override
    public DataResult<List<OrderResponseDto>> getAllOrders() {
        List<Order> orders = this.orderRepository.findAll();
        List<OrderResponseDto> orderResponseDtoList =this.convertToProductResponseDto(orders);
        return new SuccessDataResult<List<OrderResponseDto>>(orderResponseDtoList);
    }

    @Override
    public Result deleteById(int id) {
        Order order=this.orderRepository.getByOrderId(id);
        this.orderRepository.delete(order);
        return new SuccessResult(Messages.orderDeletedMessage);
    }

    @Override
    public Result updateOrder(OrderUpdatedRequestDto orderUpdatedRequestDto) {
        var data = this.productService.getById(orderUpdatedRequestDto.getProductId());
        if (!data.getSuccess()) {
            return data;
        }
        Order order =this.orderRepository.getByOrderId(orderUpdatedRequestDto.getProductId());
        order.setProductId(orderUpdatedRequestDto.getProductId());
        order.setPiece(orderUpdatedRequestDto.getPiece());
        double total=(data.getData().getUnitPrice()*orderUpdatedRequestDto.getPiece());
        order.setTotal(total);

        return new SuccessResult(Messages.orderModifiedMessage);
    }
    private List<OrderResponseDto> convertToProductResponseDto(List<Order> orders) {

        List<OrderResponseDto> orderResponseDtoList=new ArrayList<>();
        for (Order order : orders) {
            ProductResponseDto productResponseDto=this.productService.getById(order.getProductId()).getData();
            OrderResponseDto orderResponseDto=new OrderResponseDto();
            orderResponseDto.setPiece(order.getPiece());
            orderResponseDto.setTotal(order.getTotal());
            orderResponseDto.setProductResponseDto(productResponseDto);
            orderResponseDtoList.add(orderResponseDto);
        }
        return orderResponseDtoList;
    }

}