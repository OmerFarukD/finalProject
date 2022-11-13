package com.example.finalproject.Repository;

import com.example.finalproject.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IOrderRepository extends JpaRepository<Order,Integer> {

    Order getByOrderId(int id);
}
