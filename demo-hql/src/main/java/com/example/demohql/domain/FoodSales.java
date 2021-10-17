package com.example.demohql.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class FoodSales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String region;

    Date orderDate;

    String city;
    String category;
    String product;
    Integer quantity;
    Double unitPrice;
    Double totalPrice;

}
