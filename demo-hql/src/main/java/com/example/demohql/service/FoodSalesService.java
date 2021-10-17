package com.example.demohql.service;

import com.example.demohql.domain.FoodSales;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FoodSalesService {

List<FoodSales> foodSales(String city);

}
