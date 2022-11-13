package com.example.finalproject.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name ="orders")
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "piece")
    private int piece;

    @Column(name = "total")
    private double total;

    @Column(name = "productId")
    private int productId;


    @OneToMany(mappedBy = "order")
    List<Product> products;
}
