package com.amalitech.upskilling.week_two.lab_one.structural.decorator.shapes;

import com.amalitech.upskilling.OutPut;

public class TransparencyDecorator extends ShapeDecorator {
    private final double transparency;

    public TransparencyDecorator(Shape decoratedShape, double transparency) {
        super(decoratedShape);
        this.transparency = transparency;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        OutPut.printColoredTextBlock("Applying " + transparency + " transparency effect", OutPut.Colors.RESET);
    }
}
