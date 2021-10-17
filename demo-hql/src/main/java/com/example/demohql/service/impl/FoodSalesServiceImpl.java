package com.example.demohql.service.impl;

import com.example.demohql.domain.FoodSales;
import com.example.demohql.repo.FoodSalesRepo;
import com.example.demohql.service.FoodSalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class FoodSalesServiceImpl implements FoodSalesService {
    private final FoodSalesRepo foodSalesRepo;

    @Override
    public List<FoodSales> getSalesbyCity(String city) {
        return foodSalesRepo.findByCity(city);
    }

    @Override
    public Map<Date, List<FoodSales>> getSalesByDate() {
        List<FoodSales> sales = foodSalesRepo.findAll();

        Map<Date, List<FoodSales>> map = new TreeMap<>();

        sales.stream()
                .forEach(
                        el -> {
                            if (map.get(el.getOrderDate()) == null) {
                                List l = new ArrayList();
                                l.add(el);

                                map.put(el.getOrderDate(), l);
                            } else {
                                List<FoodSales> foodSales = map.get(el.getOrderDate());
                                foodSales.add(el);
                                map.put(el.getOrderDate(),foodSales);

                            }
                        }
                );

        return map;
    }

    @Override
    public List<FoodSales> findAll() {
        return foodSalesRepo.findAll();
    }

    ;
}
