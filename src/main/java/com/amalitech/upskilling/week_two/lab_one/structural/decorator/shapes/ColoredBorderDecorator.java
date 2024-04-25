package com.amalitech.upskilling.week_two.lab_one.structural.decorator.shapes;

import com.amalitech.upskilling.OutPut;

public class ColoredBorderDecorator extends ShapeDecorator {
    private final String color;
    public ColoredBorderDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public void draw() {
        String colorConstant = "Applying " + color + " colored border";
        decoratedShape.draw();
//        switch case state to print a colored border according to the color
        switch (color) {
            case "RED":
                OutPut.printColoredTextBlock(colorConstant, OutPut.Colors.RED);
                break;
            case "GREEN":
                OutPut.printColoredTextBlock(colorConstant, OutPut.Colors.GREEN);
                break;
            case "BLUE":
                OutPut.printColoredTextBlock(colorConstant, OutPut.Colors.BLUE);
                break;
            default:
                OutPut.printColoredTextBlock(colorConstant, OutPut.Colors.YELLOW);
        }
    }
}

