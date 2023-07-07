package com.sohaib.encryption;


import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption02 {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String SUBSTITUTION = "zyxwvutsrqponmlkjihgfedcba";



    public static void main(String[] args) {
        String plaintext = "Hello, World!";
//        String encryptedText = encrypt(plaintext);
//        System.out.println("Plaintext: " + plaintext);
//        System.out.println("Encrypted Text: " + encrypt(plaintext));
//        System.out.println("Encrypted Text: " + encrypt("hello"));
    }


    public static void encrypt( String plaintext  ) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        // Encrypt the plaintext

        // Generate a secret key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();

        // Create a Cipher instance and initialize it for encryption
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt the plaintext
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

        // Convert the ciphertext to a Base64-encoded string for easier display
        String encryptedText = Base64.getEncoder().encodeToString(ciphertext);

        // Print the encrypted text
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted Text: " + encryptedText);
    }



    public static String generateKey() throws NoSuchAlgorithmException {
        // Specify the desired key size (in bits)
        int keySize = 128;

        // Generate a random encryption key
        SecretKey secretKey = generateRandomKey(keySize);

        // Get the encoded form of the key
        byte[] encodedKey = secretKey.getEncoded();

        // Print the key as a hexadecimal string
        String encryptionKey = bytesToHex(encodedKey);
        System.out.println("Encryption Key: " + encryptionKey);
        return encryptionKey;
    }

    private static SecretKey generateRandomKey(int keySize) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(keySize);
        return keyGenerator.generateKey();
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }
}
