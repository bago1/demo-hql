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
                            List<FoodSales> listFromMap = map.get(el.getOrderDate());
                            if (Objects.isNull(listFromMap)) {
                                List newList = new ArrayList();
                                newList.add(el);
                                map.put(el.getOrderDate(), newList);
                            } else {
                                listFromMap.add(el);
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
