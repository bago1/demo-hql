package com.example.demohql.repo;

import com.example.demohql.domain.FoodSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface FoodSalesRepo extends JpaRepository<FoodSales, Integer> {

    List<FoodSales> findByCity(String city);


}
