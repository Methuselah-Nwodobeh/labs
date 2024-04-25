package com.amalitech.upskilling.week_two.lab_one.structural.decorator.message;

import com.amalitech.upskilling.OutPut;

public class TextMessage implements Message {
    @Override
    public void send(String message, String color) {
        final String s = "Sending text message: ";
        switch (color) {
            case "RED" -> OutPut.printColoredTextBlock(s + message, OutPut.Colors.RED);
            case "GREEN" -> OutPut.printColoredTextBlock(s + message, OutPut.Colors.GREEN);
            case "BLUE" -> OutPut.printColoredTextBlock(s + message, OutPut.Colors.BLUE);
            case "PURPLE" -> OutPut.printColoredTextBlock(s + message, OutPut.Colors.PURPLE);
            case "WHITE" -> OutPut.printColoredTextBlock(s + message, OutPut.Colors.WHITE);
            case "MAGENTA" -> OutPut.printColoredTextBlock(s + message, OutPut.Colors.MAGENTA);
            default -> OutPut.printColoredTextBlock(s + message, OutPut.Colors.YELLOW);
        }
    }
}