package com.amalitech.upskilling.week_one.lab_three.reflections_annotations;

import com.amalitech.upskilling.OutPut;

public class TestClass {
    @LogExecutionTime
    public void testMethod1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        OutPut.printColoredTextBlock("Test method 1 executed", OutPut.Colors.CYAN);
    }

    public void testMethod2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        OutPut.printColoredTextBlock("Test method 2 executed", OutPut.Colors.CYAN);
    }
}
