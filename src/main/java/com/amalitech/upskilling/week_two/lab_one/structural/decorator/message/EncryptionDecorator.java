package com.amalitech.upskilling.week_two.lab_one.structural.decorator.message;

import com.amalitech.upskilling.OutPut;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptionDecorator extends MessageDecorator {
    private static SecretKeySpec secretKey;

    public EncryptionDecorator(Message decoratedMessage) {
        super(decoratedMessage);
    }

    public static void setKey(String myKey) {
        byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
        secretKey = new SecretKeySpec(key, "AES");
    }

    @Override
    public void send(String message, String color) {
        String encryptedMessage = encrypt(message, "ssshhhhhhhhhhh!!");
        decoratedMessage.send(encryptedMessage, color);
    }

     public static String encrypt(String strToEncrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            OutPut.printColoredTextBlock("Error while encrypting: " + e, OutPut.Colors.RED);
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            OutPut.printColoredTextBlock("Error while decrypting: " + e, OutPut.Colors.RED);
            e.printStackTrace();
        }
        return null;
    }
}

