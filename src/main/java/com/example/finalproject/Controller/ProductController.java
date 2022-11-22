package com.example.finalproject.Controller;

import com.example.finalproject.Core.Result.ApiError;
import com.example.finalproject.Dto.RequestDto.ProductAddedRequestDto;
import com.example.finalproject.Dto.RequestDto.ProductRemovedRequestDto;
import com.example.finalproject.Dto.RequestDto.ProductUpdatedRequestDto;
import com.example.finalproject.Service.Abstract.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody ProductAddedRequestDto requestDto){
        var result=this.productService.add(requestDto);
        if (!result.getSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var result=this.productService.getAll();
        if (!result.getSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody ProductRemovedRequestDto removedRequestDto){
        var result=this.productService.delete(removedRequestDto);
        if (!result.getSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public ResponseEntity<?> update(@Valid @RequestBody ProductUpdatedRequestDto productUpdatedRequestDto){
        var result=this.productService.update(productUpdatedRequestDto);
        if (!result.getSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping("/getallbyorder")
    public ResponseEntity<?> getAllProductByOrderId(@RequestParam  int id){
        var result=this.productService.getAllProductsByOrderId(id);
        if (!result.getSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/getbycategory")
    public ResponseEntity<?> getAllByCategoryId(@RequestParam int id){
        var result=this.productService.getAllByCategoryId(id);
        if (!result.getSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
