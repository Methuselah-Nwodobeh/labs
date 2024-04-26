package com.amalitech.upskilling.week_two.lab_two;

import com.amalitech.upskilling.OutPut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVService {
    private final CSVRepository csvRepository;

    public CSVService(CSVRepository csvRepository) {
        this.csvRepository = csvRepository;
    }

    public void printAll() {
        OutPut.printColoredTextBlock("CSV Records:", OutPut.Colors.BLUE);
        OutPut.printColoredTextBlock("------------------------------------------------------", OutPut.Colors.GREEN);
        List<Map<String, String>> records;
        try {
            records = new ArrayList<>(csvRepository.findAll());
        } catch (IOException e) {
            throw new CSVOpsFailedException(e);
        } catch (IllegalStateException e) {
            throw new CSVOpsFailedException("CSV headers aren't set", e);
        }
        OutPut.printColoredTextBlock("Total Records: " + records.size(), OutPut.Colors.PURPLE);

        for (Map<String, String> oneRecord : records) {
            OutPut.printColoredTextBlock(oneRecord.toString(), OutPut.Colors.CYAN);
        }
    }

    public void save(Map<String, String> data) {
        try {
            csvRepository.save(data);
            OutPut.printColoredTextBlock("Record saved successfully", OutPut.Colors.GREEN);
        } catch (IOException e) {
            throw new CSVOpsFailedException(e);
        }
    }

    public void update(int rowIndex, Map<String, String> newData) {
        try {
            csvRepository.update(rowIndex, newData);
            OutPut.printColoredTextBlock("Record updated successfully", OutPut.Colors.GREEN);
        } catch (IOException e) {
            throw new CSVOpsFailedException(e);
        }
    }

    public void delete(int rowIndex) {
        try {
            csvRepository.delete(rowIndex);
            OutPut.printColoredTextBlock("Record deleted successfully", OutPut.Colors.GREEN);
        } catch (IOException e) {
            throw new CSVOpsFailedException(e);
        }
    }
}
