package com.amalitech.upskilling.week_one.lab_two;

import com.amalitech.upskilling.OutPut;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileCopier {
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        // File to read from
        File inputFile = new File("src/main/java/com/amalitech/upskilling/lab_two/resources/test.txt");
        // Output file
        File outputFile = new File("src/main/java/com/amalitech/upskilling/lab_two/resources/output.txt");

        copyToFile(inputFile, outputFile);
    }

    private static void copyToFile(File inputFile, File outputFile) throws IOException {
        if (!checkIfOutPutFileIsEmpty(outputFile)) {
            return;
        }
        if (!checkIfInputFileIsNotEmpty(outputFile)) {
            return;
        }
        OutPut.printColoredTextBlock("Copying " + inputFile.getAbsolutePath() + " to " + outputFile.getAbsolutePath(), OutPut.Colors.BLUE);
        try (FileChannel inputChannel = FileChannel.open(inputFile.toPath(), StandardOpenOption.READ);
             FileChannel outputChannel = FileChannel.open(outputFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
            OutPut.printColoredTextBlock("Buffer created with size " + BUFFER_SIZE, OutPut.Colors.BLUE);

            int bytesRead;
            do {
                bytesRead = inputChannel.read(buffer);
                OutPut.printColoredTextBlock("Buffer read with size " + bytesRead, OutPut.Colors.BLUE);

                if (bytesRead > 0) {
                    buffer.flip();
                    outputChannel.write(buffer);
                    OutPut.printColoredTextBlock("Bytes written to output file", OutPut.Colors.BLUE);
                    buffer.clear();
                }
            } while (bytesRead > 0);
        }
        OutPut.printColoredTextBlock("File copied successfully", OutPut.Colors.GREEN);
    }

//    method to check if the file exists and is empty
    private static boolean checkIfOutPutFileIsEmpty(File outputFile){
        if (outputFile.exists() && outputFile.length() > 0) {
            // If the file is not empty, prompt the user for confirmation
            OutPut.printColoredTextBlock("Output file is not empty. Do you want to override it? (yes/no)", OutPut.Colors.PURPLE);
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("no")) {
                OutPut.printColoredTextBlock("Operation cancelled. Exiting...", OutPut.Colors.RED);
                return false;
            }
        }
        return true;
    }

//    method to check if input file is not empty
    private static boolean checkIfInputFileIsNotEmpty(File inputFile){
        if (!inputFile.exists() || inputFile.length() == 0) {
            OutPut.printColoredTextBlock("Input file is empty. Exiting...", OutPut.Colors.RED);
            return false;
        }
        return true;
    }
}

