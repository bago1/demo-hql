package com.example.demohql.web.rest;

import com.example.demohql.domain.FoodSales;
import com.example.demohql.service.FoodSalesService;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class FoodSalesController {
    private final FoodSalesService foodSalesService;


    @GetMapping("/salesgroup")
    public ResponseEntity<Map<Date, List<FoodSales>>> getSalesByDateGrouped(){
        return ResponseEntity.ok(foodSalesService.getSalesByDate());
    }
}
