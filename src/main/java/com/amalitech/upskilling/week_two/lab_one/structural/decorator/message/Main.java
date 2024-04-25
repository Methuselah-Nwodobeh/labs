package com.amalitech.upskilling.week_two.lab_one.structural.decorator.message;

public class Main {
    public static void main(String[] args) {
        // Creating a plain text message
        Message textMessage = new TextMessage();
        textMessage.send("Hello, world!", "BLUE");

        // Adding encryption to the message
        Message encryptedMessage = new EncryptionDecorator(textMessage);

        encryptedMessage.send("Hello, world! is encrypted", "MAGENTA");

        // Adding compression to the encrypted message
        Message compressedEncryptedMessage = new CompressionDecorator(encryptedMessage);

//        compressing the original message only
        Message compressedMessage = new CompressionDecorator(textMessage);
        compressedMessage.send("Hello, world! is compressed", "RED");

        // Sending the decorated message
        compressedEncryptedMessage.send("Hello, world! is encrypted and compressed", "GREEN");
    }
}
