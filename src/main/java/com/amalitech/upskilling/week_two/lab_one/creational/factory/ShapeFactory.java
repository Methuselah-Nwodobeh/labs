package com.amalitech.upskilling.week_two.lab_one.creational.factory;

import com.amalitech.upskilling.OutPut;

public class ShapeFactory {

    private ShapeFactory() {}

    public static Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        return switch (shapeType.toLowerCase()) {
            case "circle" -> new Circle();
            case "square" -> new Square();
            case "triangle" -> new Triangle();
            default -> {
                OutPut.printColoredTextBlock("Unsupported shape type: " + shapeType, OutPut.Colors.BLUE);
                yield null;
            }
        };
    }
}
