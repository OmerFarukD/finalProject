package com.example.finalproject.Controller;

import com.example.finalproject.Dto.RequestDto.OrderAddedRequestDto;
import com.example.finalproject.Dto.RequestDto.OrderUpdatedRequestDto;
import com.example.finalproject.Service.Abstract.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody OrderAddedRequestDto orderAddedRequestDto){
        var result=this.orderService.add(orderAddedRequestDto);
        if (!result.getSuccess()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @GetMapping("/getalldetails")
    public ResponseEntity<?> getAll(){
        var result=this.orderService.getAllOrders();
        if (!result.getSuccess()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @PostMapping("/delete")
    public ResponseEntity<?> deleteById(@RequestParam int id){
        var result=this.orderService.deleteById(id);
        if (!result.getSuccess()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody OrderUpdatedRequestDto orderUpdatedRequestDto){
        var result=this.orderService.updateOrder(orderUpdatedRequestDto);
        if (!result.getSuccess()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
