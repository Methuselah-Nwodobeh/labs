package com.amalitech.upskilling.lab_three.reflections_annotations;

import com.amalitech.upskilling.OutPut;

import java.lang.reflect.Method;
import java.time.Duration;

public class ExecutionTimeLogger {
    private ExecutionTimeLogger() {
    }

    public static void logExecutionTime(Object target) {
        System.out.println("starting calculation");
        Class<?> targetClass = target.getClass();
        Method[] methods = targetClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                try {
                    method.invoke(target);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                long endTime = System.nanoTime();

                long executionTime = endTime - startTime;
                Duration duration = Duration.ofNanos(executionTime);
                long seconds = duration.getSeconds();
                OutPut.printColoredText("Method " + method.getName() + " executed in " + seconds + " seconds or" + executionTime + " nanoseconds", OutPut.Colors.CYAN);
            }
        }
    }
}
