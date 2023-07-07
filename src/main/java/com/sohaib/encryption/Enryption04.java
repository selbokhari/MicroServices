package com.sohaib.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Enryption04 {
    private static final String SECRET_KEY = "mysecretkey12345"; // 16 characters for AES-128

    public static String encryptChar(char character) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(String.valueOf(character).getBytes(StandardCharsets.UTF_8));
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        return encryptedText.substring(0, 2); // Truncate the encrypted text to two characters
    }

    public static StringBuilder crypter(String text) throws Exception {

        char[] characters = text.toCharArray();
        StringBuilder encryptedText = new StringBuilder();
        for (char c : characters) {
            encryptedText.append(encryptChar(c));
        }
        return encryptedText;
    }

    public static void main(String[] args) throws Exception {
        String text01 =  "SOHAIB ELBOKHARI";
        String text02 =  "SOHAIB";


        System.out.println("Text 01 : " + text01);
        System.out.println("Encrypted Text: " + crypter(text01) );

        System.out.println("------------------");
        System.out.println("Text 02 : " + text02);
        System.out.println("Encrypted Text: " + crypter(text02) );

    }
}
