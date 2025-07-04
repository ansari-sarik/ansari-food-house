package com.ansari.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @ManyToOne
    private User customer;


    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    private Long TotalAmount;

    private String orderStatus;

    private LocalDateTime createdAt;



    @ManyToOne
    private Address deliveryAddress;

    @OneToMany
    private List<OrderItem> items;

//    private Payment payment;

    private int totalItem;


    private int totalPrice;

}
