package com.example.demohql.service;

import com.example.demohql.domain.FoodSales;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface FoodSalesService {

    List<FoodSales> getSalesbyCity(String city);

    Map<Date, List<FoodSales>> getSalesByDate();

    List<FoodSales> findAll();
}
