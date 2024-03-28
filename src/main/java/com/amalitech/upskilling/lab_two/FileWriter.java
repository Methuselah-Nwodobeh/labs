package com.amalitech.upskilling.lab_two;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileWriter {

    private static final int BUFFER_SIZE = 1024;

    /**
     * Writes the given input text to a file.
     *
     * @param inputText the text to be written to the file
     * @return the number of bytes written to the file
     */
    private static int writeToFile(String inputText) {

        File outputFile = new File("src/main/java/com/amalitech/upskilling/lab_two/writeto.txt");

        try (FileChannel outputChannel = FileChannel.open(outputFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

            buffer.put(inputText.getBytes());
            buffer.flip();
            return outputChannel.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input text to write to the output file
        String inputText = scanner.nextLine();
        System.out.println(writeToFile(inputText));
    }
}

