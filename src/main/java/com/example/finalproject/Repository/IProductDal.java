package com.example.finalproject.Repository;

import com.example.finalproject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductDal extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);
    List<Product> getAllByOrder_OrderId(int orderId);
    List<Product> getAllByCategory_CategoryId(int id);
    Product getByProductId(int id);

    Product getByCategory_CategoryId(int categoryId);

}
