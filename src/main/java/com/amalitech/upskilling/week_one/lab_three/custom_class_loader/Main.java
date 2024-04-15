package com.amalitech.upskilling.week_one.lab_three.custom_class_loader;

import com.amalitech.upskilling.OutPut;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        String customDirectory = "src/main/java/com/amalitech/upskilling/lab_three/custom_class_loader";

        CustomClassLoader classLoader = new CustomClassLoader(customDirectory, Main.class.getClassLoader());

        String className = "com.amalitech.upskilling.lab_three.custom_class_loader.Test";
        Class<?> loadedClass = classLoader.loadClass(className);

        Object instance = loadedClass.getDeclaredConstructor().newInstance();
        Method method = loadedClass.getDeclaredMethod("printit");
        Object result = method.invoke(instance);
        OutPut.printColoredTextBlock("This is loaded class: " + instance, OutPut.Colors.CYAN);
        OutPut.printColoredTextBlock("This is loaded method: " + method, OutPut.Colors.PURPLE);
        OutPut.printColoredTextBlock("This is loaded method result: " + result, OutPut.Colors.YELLOW);
    }
}