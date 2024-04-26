package com.amalitech.upskilling.week_two.lab_two;

import org.apache.commons.csv.*;

import java.io.*;
import java.util.*;

public class CSVRepository {

    private final String csvFilePath;
    private final CSVFormat csvFormat;

    public CSVRepository(String csvFilePath, CSVFormat csvFormat) {
        this.csvFilePath = csvFilePath;
        this.csvFormat = csvFormat;
    }

    public List<Map<String, String>> findAll() throws IOException {
    List<Map<String, String>> records = new ArrayList<>();
    try (Reader reader = new FileReader(csvFilePath);
         CSVParser csvParser = new CSVParser(reader, csvFormat)) {
        // Get the headers from the first record
        List<String> headers = csvParser.getHeaderNames();

        for (CSVRecord csvRecord : csvParser) {
            Map<String, String> recordMap = new LinkedHashMap<>();
            for (int i = 0; i < headers.size(); i++) {
                String header = headers.get(i);
                String value = csvRecord.get(i);
                recordMap.put(header, value);
            }
            records.add(recordMap);
        }
    }
    return records;
}

    public void save(Map<String, String> data) throws IOException {
        try (Writer writer = new FileWriter(csvFilePath, true);
             CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat)) {
            csvPrinter.printRecord(data.values().stream().sorted().toList());
        }
    }

    public void update(int rowIndex, Map<String, String> newData) throws IOException {
        List<Map<String, String>> records = findAll();
        if (rowIndex >= 0 && rowIndex < records.size()) {
            records.set(rowIndex, newData);
            writeAll(records);
        } else {
            throw new IllegalArgumentException("Invalid row index");
        }
    }

    public void delete(int rowIndex) throws IOException {
        List<Map<String, String>> records = findAll();
        if (rowIndex >= 0 && rowIndex < records.size()) {
            records.remove(rowIndex);
            writeAll(records);
        } else {
            throw new IllegalArgumentException("Invalid row index");
        }
    }

    private void writeAll(List<Map<String, String>> records) throws IOException {
        try (Writer writer = new FileWriter(csvFilePath);
             CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat)) {
            for (Map<String, String> csvRecord : records) {
                csvPrinter.printRecord(csvRecord.values().stream().sorted().toList());
            }
        }
    }
}
