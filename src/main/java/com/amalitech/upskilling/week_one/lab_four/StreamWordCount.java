package com.amalitech.upskilling.week_one.lab_four;

import com.amalitech.upskilling.OutPut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StreamWordCount {
    public static Stream<String> readFileAsStream(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        return reader.lines().onClose(() -> {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static Map<String, Integer> countWords(String path) {
        Map<String, Integer> wordCounts = new HashMap<>();
        try (Stream<String> lines = readFileAsStream(path)) {
            lines.forEach(line -> {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (word.matches("[a-zA-Z]+")) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordCounts;
    }

    public static void main(String[] args) {
        Map<String, Integer> wordCounts = countWords("src/main/java/com/amalitech/upskilling/week_one/lab_four/resources/ptl_lyrics.txt");
        OutPut.printColoredTextBlock("Word Count:", OutPut.Colors.MAGENTA);
        OutPut.printColoredTextBlock("------------------------------------------------------", OutPut.Colors.CYAN);
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            OutPut.printColoredTextInline(entry.getKey(), OutPut.Colors.BLUE);
            OutPut.printColoredTextInline(":", OutPut.Colors.YELLOW);
            OutPut.printColoredTextBlock(String.valueOf(entry.getValue()), OutPut.Colors.PURPLE);
        }
    }
}
