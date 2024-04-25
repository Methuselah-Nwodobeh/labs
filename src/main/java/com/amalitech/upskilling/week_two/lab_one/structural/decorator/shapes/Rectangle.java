package com.amalitech.upskilling.week_two.lab_one.structural.decorator.shapes;

import com.amalitech.upskilling.OutPut;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        OutPut.printColoredTextBlock("Drawing a rectangle", OutPut.Colors.BLUE);
    }
}
