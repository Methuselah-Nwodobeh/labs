package com.amalitech.upskilling.week_one.lab_three.reflections_annotations;

import com.amalitech.upskilling.OutPut;

import java.lang.reflect.Method;
import java.time.Duration;

public class ExecutionTimeLogger {
    private ExecutionTimeLogger() {
    }

    public static void logExecutionTime(Object target) {
        OutPut.printColoredTextBlock("starting calculation", OutPut.Colors.MAGENTA);
        OutPut.printColoredTextBlock("------------------------------------------------------", OutPut.Colors.CYAN);
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
                OutPut.printColoredTextBlock("Method " + method.getName() + " executed in " + seconds + " seconds or" + executionTime + " nanoseconds", OutPut.Colors.CYAN);
            }
        }
    }
}
