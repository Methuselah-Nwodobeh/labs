package com.amalitech.upskilling.week_two.lab_one.structural.adapter.csv_processing;

import com.amalitech.upskilling.OutPut;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Path to the CSV file
        String filePath = "src/main/java/com/amalitech/upskilling/week_two/lab_one/structural/adapter/csv_processing/resources/data.csv";

        // Create an adapter for the CSV file
        DataSource csvDataSource = new CSVDataSourceAdapter(filePath);

        try {
            // Read data from the CSV file
            OutPut.printColoredTextBlock("Reading data from CSV:", OutPut.Colors.MAGENTA);
            List<String[]> data = csvDataSource.readData();
            printData(data);

            // Write data to the CSV file
            OutPut.printColoredTextBlock("\nWriting data to CSV:", OutPut.Colors.MAGENTA);
            csvDataSource.writeData("4,John,Doe\n");

            // Read updated data from the CSV file
            OutPut.printColoredTextBlock("\nReading updated data from CSV:", OutPut.Colors.MAGENTA);
            data = csvDataSource.readData();
            printData(data);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printData(List<String[]> data) {
        for (String[] row : data) {
            for (String field : row) {
                OutPut.printColoredTextInline(field + "\t", OutPut.Colors.BLUE);
            }
            System.out.println();
        }
    }
}
