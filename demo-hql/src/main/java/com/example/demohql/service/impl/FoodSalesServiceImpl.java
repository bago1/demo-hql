package com.example.demohql.service.impl;

import com.example.demohql.domain.FoodSales;
import com.example.demohql.repo.FoodSalesRepo;
import com.example.demohql.service.FoodSalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodSalesServiceImpl implements FoodSalesService {
    private final FoodSalesRepo foodSalesRepo;

    @Override
    public List<FoodSales> foodSales(String city) {
       return foodSalesRepo.findByCity(city);
    }
}
