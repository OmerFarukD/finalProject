package com.example.finalproject.Dto.RequestDto;

import com.example.finalproject.Annotations.OrderBusinesRules.OrderBusinessRule;
import lombok.Data;

@Data
@OrderBusinessRule
public class OrderUpdatedRequestDto {

    private int orderId;

    private int piece;

    private int productId;

}
