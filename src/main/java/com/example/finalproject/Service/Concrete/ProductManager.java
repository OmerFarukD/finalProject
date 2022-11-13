package com.example.finalproject.Service.Concrete;

import com.example.finalproject.Core.Result.*;
import com.example.finalproject.Dto.RequestDto.ProductAddedRequestDto;
import com.example.finalproject.Dto.RequestDto.ProductRemovedRequestDto;
import com.example.finalproject.Dto.RequestDto.ProductUpdatedRequestDto;
import com.example.finalproject.Dto.ResponseDto.ProductResponseDto;
import com.example.finalproject.Entity.Category;
import com.example.finalproject.Entity.Product;
import com.example.finalproject.Repository.IProductDal;
import com.example.finalproject.Service.Abstract.ICategoryService;
import com.example.finalproject.Service.Abstract.IProductService;
import com.example.finalproject.Service.Constants.Messages;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductManager implements IProductService {

    private final IProductDal productDal;

    private final ModelMapper modelMapper;

    private final ICategoryService categoryService;


    @Override
    public Result add( ProductAddedRequestDto requestDto) {

        var data=this.categoryService.getByCategoryId(requestDto.getCategoryId());
        if(!data.getSuccess()){
            return data;
        }
        Category category=new Category();
        category.setCategoryId(requestDto.getCategoryId());
        category.setCategoryName(data.getData().getCategoryName());
        Product product=new Product();
        product.setProductName(requestDto.getProductName());
        product.setCategory(category);
        product.setUnitPrice(requestDto.getUnitPrice());
        product.setUnitsInStock(requestDto.getUnitsInStock());
        this.productDal.save(product);
        return new SuccessResult(Messages.productAddedMessage);
    }

    @Override
    public DataResult<List<ProductResponseDto>> getAll() {
        List<Product> products=this.productDal.findAll();
        List<ProductResponseDto> responseDtoList=this.listResponseDtoConverter(products);
        return new SuccessDataResult<List<ProductResponseDto>>(responseDtoList,Messages.productsListedMessage);
    }

    @Override
    public Result delete(ProductRemovedRequestDto removedRequestDto) {
        Product product=this.modelMapper.map(removedRequestDto,Product.class);
        this.productDal.delete(product);
        return new SuccessResult(Messages.productRemovedMessage);
    }

    @Override
    public DataResult<List<ProductResponseDto>> getAllProductsByOrderId(int orderId) {
        List<ProductResponseDto> responseDtoList=this.listResponseDtoConverter(
                this.productDal.getAllByOrder_OrderId(orderId));
        return new SuccessDataResult<>(responseDtoList);
    }

    @Override
    public DataResult<ProductResponseDto> getById(int id) {
        Product product=this.productDal.getById(id);
        if (product==null){
            return new ErrorDataResult<ProductResponseDto>(Messages.productNotFoundMessage);
        }
        ProductResponseDto productResponseDto=this.modelMapper.map(product,ProductResponseDto.class);
        return new SuccessDataResult<>(productResponseDto);
    }

    @Override
    public DataResult<List<ProductResponseDto>> getAllByCategoryId(int categoryId) {

        List<Product> products=this.productDal.getAllByCategory_CategoryId(categoryId);
        List<ProductResponseDto> productResponseDtoList=this.listResponseDtoConverter(products);
        return new SuccessDataResult<List<ProductResponseDto>>(productResponseDtoList);
    }

    @Override
    public Result update(ProductUpdatedRequestDto productUpdatedRequestDto) {

        Product product=this.modelMapper.map(productUpdatedRequestDto,Product.class);
        this.productDal.save(product);
        return new SuccessResult(Messages.productModifiedMessage);
    }
    // Converters
    private List<ProductResponseDto> listResponseDtoConverter(List<Product> productList){
        return productList.stream().map(x->modelMapper.map(x,ProductResponseDto.class)).collect(Collectors.toList());
    }
}