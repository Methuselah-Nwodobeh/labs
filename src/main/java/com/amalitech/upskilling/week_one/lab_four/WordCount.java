package com.amalitech.upskilling.week_one.lab_four;

import com.amalitech.upskilling.OutPut;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
//    method to open a file and return the text
    private static String openFile(String path){
        File file = new File(path);
        if (file.exists()) {
            try {
                return new String(Files.readAllBytes(file.toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static void main(String[] args) {
//        String text = openFile("src/main/java/com/amalitech/upskilling/lab_four/resources/1gb_file.txt");
         String text = "Apache Spark is a powerful open-source processing engine for big data analytics. " +
                "Spark’s architecture is based on Resilient Distributed Datasets (RDDs) and features a distributed execution engine. " +
                "Spark lets you run programs up to 100x faster in memory, or 10x faster on disk, than Hadoop.";

        String[] words = text.split("\\s+");

        Map<String, Integer> wordCounts = new HashMap<>();
        List<String> wordsList = List.of(words);
        wordsList.forEach(word -> wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1));

//        for (String word : words) {
//            word = word.toLowerCase();
//            if (word.matches("[a-zA-Z]+")) {
//                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
//            }
//        }

        OutPut.printColoredTextBlock("Word Count:", OutPut.Colors.MAGENTA);
        OutPut.printColoredTextBlock("------------------------------------------------------", OutPut.Colors.CYAN);
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            OutPut.printColoredTextInline(entry.getKey(), OutPut.Colors.BLUE);
            OutPut.printColoredTextInline(":", OutPut.Colors.YELLOW);
            OutPut.printColoredTextBlock(String.valueOf(entry.getValue()), OutPut.Colors.PURPLE);
        }
    }
}
