package com.sohaib.encryption;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class Encrypt03 {
    public static String encrypt(char character, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(String.valueOf(character).getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encryptedBytes); // Convertir les octets chiffrés en une représentation hexadécimale pour faciliter l'affichage
    }

    public static void main(String[] args) throws Exception {
        String plaintext = "Hello, World!";

        // Générer une paire de clés RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(524); // Taille de clé recommandée pour RSA
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        StringBuilder encryptedText = new StringBuilder();
        System.out.println("publicKey : "+publicKey.getEncoded());

        for (char c : plaintext.toCharArray()) {
            String encryptedChar = encrypt(c, publicKey);
            encryptedText.append(encryptedChar);
        }

        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted Text: " + encryptedText.toString());
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }
}