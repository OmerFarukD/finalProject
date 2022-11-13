package com.example.finalproject.Service.Concrete;

import com.example.finalproject.Core.Result.*;
import com.example.finalproject.Dto.RequestDto.CategoryAddedRequestDto;
import com.example.finalproject.Dto.RequestDto.CategoryUpdatedRequestDto;
import com.example.finalproject.Dto.ResponseDto.CategoryResponseDto;
import com.example.finalproject.Entity.Category;
import com.example.finalproject.Repository.ICategoryDal;
import com.example.finalproject.Service.Abstract.ICategoryService;
import com.example.finalproject.Service.Constants.Messages;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryManager implements ICategoryService {

    private final ICategoryDal categoryDal;
    private final ModelMapper modelMapper;

    @Override
    public Result add(@Valid CategoryAddedRequestDto requestDto) {
        Category category=new Category();
        category.setCategoryName(requestDto.getCategoryName());
        this.categoryDal.save(category);
        return new SuccessResult(Messages.categoryAddedMessage);
    }

    @Override
    public DataResult<List<CategoryResponseDto>> getAll() {
        List<Category> categories=this.categoryDal.findAll();
        List<CategoryResponseDto> responseDtoList=this.listResponseDtoConverter(categories);
        return new SuccessDataResult<List<CategoryResponseDto>>(responseDtoList,Messages.categoriesListedMessage);
    }

    @Override
    public DataResult<CategoryResponseDto> getByCategoryId(int id) {
        var data=this.categoryDal.getByCategoryId(id);
        if (data==null){
            return new ErrorDataResult<CategoryResponseDto>(Messages.categoryNotFoundMessage);
        }else {
            CategoryResponseDto categoryResponseDto=this.modelMapper.map(data,CategoryResponseDto.class);
            return new SuccessDataResult<CategoryResponseDto>(categoryResponseDto);
        }
    }

    @Override
    public Result deleteById(int id) {

        Category category=this.categoryDal.getByCategoryId(id);
        this.categoryDal.delete(category);
        return new SuccessResult(Messages.categoryRemovedMessage);
    }

    @Override
    public Result update(CategoryUpdatedRequestDto categoryUpdatedRequestDto) {
        Category category=this.modelMapper.map(categoryUpdatedRequestDto,Category.class);
       this.categoryDal.save(category);
        return new SuccessResult(Messages.categoryUpdatedMessage);
    }

    // Converter
    private List<CategoryResponseDto> listResponseDtoConverter(List<Category> categories){
        return categories.stream().map(x->modelMapper.map(x,CategoryResponseDto.class)).collect(Collectors.toList());
    }

}
