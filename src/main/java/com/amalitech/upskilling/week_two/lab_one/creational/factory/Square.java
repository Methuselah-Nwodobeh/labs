package com.amalitech.upskilling.week_two.lab_one.creational.factory;

import com.amalitech.upskilling.OutPut;

public class Square implements Shape {

    @Override
    public void draw() {
        OutPut.printColoredTextBlock("Drawing a square", OutPut.Colors.BLUE);
        OutPut.printColoredTextBlock("------------------------------------------------------", OutPut.Colors.RED);
//        print a circle using ascii characters
        String square = """
                     **********
                     *        *
                     *        *
                     *        *
                     **********
                """;
        OutPut.printColoredTextBlock(square, OutPut.Colors.CYAN);
    }
}
