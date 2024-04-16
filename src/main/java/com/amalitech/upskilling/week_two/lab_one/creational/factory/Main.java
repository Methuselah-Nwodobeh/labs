package com.amalitech.upskilling.week_two.lab_one.creational.factory;

public class Main {
    public static void main(String[] args) {

          // Create shapes using the factory method
        Shape circle = ShapeFactory.createShape("circle");
        if (circle != null) {
            circle.draw();
        }

        Shape square = ShapeFactory.createShape("square");
        if (square != null) {
            square.draw();
        }

        Shape triangle = ShapeFactory.createShape("triangle");
        if (triangle != null) {
            triangle.draw();
        }

        // Try creating an unsupported shape
        ShapeFactory.createShape("triangle");
        // Output: Unsupported shape type: triangle
    }
}
