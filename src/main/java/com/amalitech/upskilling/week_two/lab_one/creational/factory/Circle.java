package com.amalitech.upskilling.week_two.lab_one.creational.factory;

import com.amalitech.upskilling.OutPut;

public class Circle implements Shape {
    @Override
    public void draw() {
        OutPut.printColoredTextBlock("Drawing a circle", OutPut.Colors.BLUE);
        OutPut.printColoredTextBlock("------------------------------------------------------", OutPut.Colors.RED);
//        print a circle using ascii characters
        String circle = """
                    *****
                  *       *
                 *         *
                 *         *
                 *         *
                 *         *
                 *         *
                  *       *
                    *****
                """;
        OutPut.printColoredTextBlock(circle, OutPut.Colors.CYAN);
    }
}