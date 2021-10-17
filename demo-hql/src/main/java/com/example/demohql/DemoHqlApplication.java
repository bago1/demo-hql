package com.example.demohql;

import com.example.demohql.domain.FoodSales;
import com.example.demohql.service.FoodSalesService;
import com.example.demohql.service.impl.FoodSalesServiceImpl;
import com.example.demohql.util.ExcelData;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoHqlApplication implements CommandLineRunner {

    private final FoodSalesService foodSalesService;

    public static void main(String[] args) {
        SpringApplication.run(DemoHqlApplication.class, args);


    }


    @Override
    public void run(String... args) throws Exception {
        ExcelData.getDataFromExcelAndSaveToDb();
//        List<FoodSales> salesListByCity = foodSalesService.getfoodSalesbyCity("Boston");
//           System.out.println(salesListByCity);

//        Map<Date, List<FoodSales>> salesByDate = foodSalesService.getSalesByDate();
//        System.out.println(salesByDate);

        List<FoodSales> allSales = foodSalesService.findAll();
        System.out.println(allSales);
    }
}

