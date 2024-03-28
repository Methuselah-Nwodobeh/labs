package com.amalitech.upskilling.lab_three.reflections_annotations;

public class TestClass {
    @LogExecutionTime
    public void testMethod1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test method 1 executed");
    }

    public void testMethod2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test method 2 executed");
    }
}
