package com.amalitech.upskilling.week_two.lab_one.structural.decorator.message;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.zip.*;

public class CompressionDecorator extends MessageDecorator {
    public CompressionDecorator(Message decoratedMessage) {
        super(decoratedMessage);
    }

    @Override
    public void send(String message, String color) {
        String compressedMessage;
        try {
            compressedMessage = Arrays.toString(compress(message));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        decoratedMessage.send(compressedMessage, color);
    }

    // Compresses the input string and returns a byte array
    public static byte[] compress(String str) throws IOException {
        if (str == null || str.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
            gzipOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
        }
        return byteArrayOutputStream.toByteArray();
    }

    // Decompresses the input byte array and returns a string
    public static String decompress(byte[] compressed) throws IOException {
        if (compressed == null || compressed.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(compressed))) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzipInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
        }
        return byteArrayOutputStream.toString(StandardCharsets.UTF_8);
    }
}
