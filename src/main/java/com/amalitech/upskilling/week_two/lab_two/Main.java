package com.amalitech.upskilling.week_two.lab_two;

import org.apache.commons.csv.CSVFormat;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Specify CSV file path
        String csvFilePath = "src/main/java/com/amalitech/upskilling/week_two/lab_two/resources/AMAP_Computer_fundamentals_1 - Sheet1.csv";

        // Specify CSV format


        CSVService csvService = getCsvService(csvFilePath);

        // Example: printing all records
        csvService.printAll();

        // Example: saving a record
        Map<String, String> dataToSave = new HashMap<>();
        String difficultyLevel = "Difficulty_Level";
        dataToSave.put(difficultyLevel, "Beginner");
        String questionText = "Question_Text";
        dataToSave.put(questionText, "What is javascript?");
        csvService.save(dataToSave);

        // Example: updating a record
        int rowIndexToUpdate = 2; // Assuming you want to update the first record
        Map<String, String> newData = new HashMap<>();
        newData.put(difficultyLevel, "Beginner");
        newData.put(questionText, "Who is the father of Computers?");
        csvService.update(rowIndexToUpdate, newData);

        // Example: deleting a record
        int rowIndexToDelete = 2;
        csvService.delete(rowIndexToDelete);
    }

    private static CSVService getCsvService(String csvFilePath) {
        String[] headers = {"Difficulty_Level", "Question_Text"};
        CSVFormat csvFormat = CSVFormat.RFC4180.withHeader(headers).withSkipHeaderRecord(true);

        CSVRepository csvRepository = new CSVRepository(csvFilePath, csvFormat);
        return new CSVService(csvRepository);
    }
}
