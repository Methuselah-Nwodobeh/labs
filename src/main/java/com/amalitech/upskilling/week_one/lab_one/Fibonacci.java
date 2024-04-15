package com.amalitech.upskilling.week_one.lab_one;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
    public Fibonacci(int inputNumber) {
        this.inputNumber = inputNumber;
    }

    private final int inputNumber;
    @Override
    protected Integer compute() {
        if (inputNumber <= 1) {
            return inputNumber;
        }
        Fibonacci f1 = new Fibonacci(inputNumber - 1);
        Fibonacci f2 = new Fibonacci(inputNumber - 2);
        f1.fork();
        f2.fork();
        return f1.join() + f2.join();
    }

    public static void main(String[] args) {
        Fibonacci fibonacci;
        int result;
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            int inputNumber = 20;
            fibonacci = new Fibonacci(inputNumber);
            result = forkJoinPool.invoke(fibonacci);
        }
        System.out.println(result);
    }
}
