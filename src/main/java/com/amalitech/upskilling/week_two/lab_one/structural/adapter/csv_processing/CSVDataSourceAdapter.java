package com.amalitech.upskilling.week_two.lab_one.structural.adapter.csv_processing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVDataSourceAdapter implements DataSource {
    private final String filePath;

    public CSVDataSourceAdapter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String[]> readData() throws IOException {
        return readLines();
    }

    @Override
    public void writeData(String data) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
        }
    }

    private List<String[]> readLines() throws IOException {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                lines.add(fields);
            }
        }
        return lines;
    }
}
