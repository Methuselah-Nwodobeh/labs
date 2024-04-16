package com.amalitech.upskilling.week_one.lab_four;

import com.amalitech.upskilling.OutPut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    //    method to open a file and return the text
    private static Map<String, Integer> proccessor(String path) {
        Map<String, Integer> countedWords = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                countWords(line).forEach(word -> countedWords.put(word, countedWords.getOrDefault(word, 0) + 1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countedWords;
    }


    private static List<String> countWords(String text) {
        String[] words = text.split("\\s+");
        return List.of(words);
    }


    public static void main(String[] args) {
        OutPut.printColoredTextBlock("Program Start:", OutPut.Colors.BLUE);
        OutPut.printColoredTextBlock("------------------------------------------------------", OutPut.Colors.GREEN);
        Map<String, Integer> wordCounts = proccessor("src/main/java/com/amalitech/upskilling/week_one/lab_four/resources/ptl_lyrics.txt");

        OutPut.printColoredTextBlock("Word Count:", OutPut.Colors.MAGENTA);
        OutPut.printColoredTextBlock("------------------------------------------------------", OutPut.Colors.CYAN);
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            OutPut.printColoredTextInline(entry.getKey(), OutPut.Colors.BLUE);
            OutPut.printColoredTextInline(":", OutPut.Colors.YELLOW);
            OutPut.printColoredTextBlock(String.valueOf(entry.getValue()), OutPut.Colors.PURPLE);
        }
    }
}
