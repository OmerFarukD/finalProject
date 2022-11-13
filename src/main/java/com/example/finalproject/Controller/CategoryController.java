package com.example.finalproject.Controller;

import com.example.finalproject.Core.Result.ApiError;
import com.example.finalproject.Dto.RequestDto.CategoryAddedRequestDto;
import com.example.finalproject.Dto.RequestDto.CategoryUpdatedRequestDto;
import com.example.finalproject.Service.Abstract.ICategoryService;
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
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CategoryAddedRequestDto requestDto){
        var result=this.categoryService.add(requestDto);
        if (!result.getSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var result=this.categoryService.getAll();
        if (!result.getSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
@PostMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody CategoryUpdatedRequestDto categoryUpdatedRequestDto){
        var result=this.categoryService.update(categoryUpdatedRequestDto);
        if (!result.getSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/getbycategoryid")
    public ResponseEntity<?> getByCategoryId(@RequestParam int id){
        var result=this.categoryService.getByCategoryId(id);
        if (!result.getSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        var result=this.categoryService.deleteById(id);
        if (!result.getSuccess()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
