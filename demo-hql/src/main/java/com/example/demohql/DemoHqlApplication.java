package com.example.demohql;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.Iterator;

@SpringBootApplication
public class DemoHqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHqlApplication.class, args);

        String jdbcURL = "jdbc:h2:file:~/hql-demo";
        String username = "sa";
        String password = "";

        String excelFilePath = "C:\\Users\\Bago\\Documents\\excel files\\food_sales.xlsx";

        int batchSize = 20;

        Connection connection = null;

        try {
            long start = System.currentTimeMillis();

            FileInputStream inputStream = new FileInputStream(excelFilePath);

            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();

            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);

            String sql = "INSERT INTO food_sales (" +
                    "id," +
                    "region," +
                    "order_date," +
                    "city," +
                    "category," +
                    "product," +
                    "quantity," +
                    "unit_price," +
                    "total_price" +
                    ") VALUES (?, ?, ?,?, ?, ?,?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            int count = 0;

            rowIterator.next(); // skip the header row

            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();

                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            int id = (int) nextCell.getNumericCellValue();
                            statement.setInt(1, id);
                            break;
                        case 1:
                            String region = nextCell.getStringCellValue();
                            statement.setString(2, region);
                            break;
                        case 2:
                            Date order_date = nextCell.getDateCellValue();
                            statement.setTimestamp(3, new Timestamp(order_date.getTime()));
                            break;

                        case 3:
                            String city = nextCell.getStringCellValue();
                            statement.setString(4, city);
                            break;
                        case 4:
                            String category = nextCell.getStringCellValue();
                            statement.setString(5, category);
                            break;
                        case 5:
                            String product = nextCell.getStringCellValue();
                            statement.setString(6, product);
                            break;
                        case 6:
                            double unit_price = nextCell.getNumericCellValue();
                            statement.setDouble(7, unit_price);
                            break;
                        case 7:
                            double total_price = nextCell.getNumericCellValue();
                            statement.setDouble(8, total_price);
                            break;


                    }

                }

                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }

            }

            workbook.close();

            // execute the remaining queries
            statement.executeBatch();

            connection.commit();
            connection.close();

            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));

        } catch (
                IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (
                SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }

    }

}

