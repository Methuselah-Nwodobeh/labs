package com.amalitech.upskilling.week_one.lab_four;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {
         public static void main(String[] args) {
        long fileSize = 1024 * 1024 * 1024L; // 1GB
        File file = new File("src/main/java/com/amalitech/upskilling/week_one/lab_four/resources/1gb_file.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (long i = 0; i < fileSize; i++) {
                char c = (char) ('a' + random.nextInt(26)); // Generating random lowercase letters
                sb.append(c);
                if (sb.length() % 7 == 0) {
                    sb.append(' '); // Add space after every 6 characters
                }
            }
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
