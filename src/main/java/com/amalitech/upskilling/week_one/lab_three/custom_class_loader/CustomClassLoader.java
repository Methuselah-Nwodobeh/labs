package com.amalitech.upskilling.week_one.lab_three.custom_class_loader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader {

    private final String directory;

    public CustomClassLoader(String directory, ClassLoader parent) {
        super(parent);
        this.directory = directory;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            byte[] classBytes = loadClassBytes(className);
            return defineClass(className, classBytes, 0, classBytes.length);
        } catch (Exception e) {
            throw new ClassNotFoundException("Failed to load class: " + className, e);
        }
    }

    private byte[] loadClassBytes(String className) throws IOException {
        String fileName = className.replace('.', File.separatorChar) + ".class";
        Path classPath = Paths.get(directory, fileName);
        return Files.readAllBytes(classPath);
    }
}