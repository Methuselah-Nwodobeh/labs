package com.amalitech.upskilling.week_two.lab_one.structural.decorator.shapes;

public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    protected ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
