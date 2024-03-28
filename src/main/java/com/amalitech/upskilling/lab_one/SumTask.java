package com.amalitech.upskilling.lab_one;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    private final List<Long> inputList;
    private final long threshold;

    public SumTask(List<Long> inputList, long threshold) {
        this.inputList = inputList;
        this.threshold = threshold;
    }

    @Override
    protected Long compute() {
        if (inputList.size() < threshold) {
            return inputList.stream().mapToLong(Long::longValue)
                    .sum();
        }

        int middle = inputList.size() / 2;
        List<Long> left = inputList.subList(0, middle);
        List<Long> right = inputList.subList(middle, inputList.size());
        SumTask leftTask = new SumTask(left, threshold);
        SumTask rightTask = new SumTask(right, threshold);
        leftTask.fork();
        rightTask.fork();
        return leftTask.join() + rightTask.join();
    }

    public static void main(String[] args) {
        List<Long> inputList = List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
        long result;
        try (ForkJoinPool pool = new ForkJoinPool()) {
//        long result = new SumTask(inputList, 5).invoke();
            result = pool.invoke(new SumTask(inputList, 5));
        }
        System.out.println(result);
    }
}
