package com.sohaib.encryption;

import com.idealista.fpe.FormatPreservingEncryption;
import com.idealista.fpe.builder.FormatPreservingEncryptionBuilder;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class Encryption {
    public static void main(String[] args) throws Exception {// with default valuesssc

        byte[] anyKey = "656320202202656320202202".getBytes(); // la longeur doit etre plus grand à 16

        FormatPreservingEncryption formatPreservingEncryption = FormatPreservingEncryptionBuilder
            .ff1Implementation()
            .withDefaultDomain()
            .withDefaultPseudoRandomFunction(anyKey)
            .withDefaultLengthRange()
            .build();

        byte[] tweak = "1000020".getBytes(StandardCharsets.UTF_8);

        String aText = "sohaibelbokhari";
        String aText2 = "sohaib";
        //usage
        String cipherText01 = formatPreservingEncryption.encrypt(aText,  tweak);
        String cipherText02 = formatPreservingEncryption.encrypt(aText2,  tweak);
        System.out.println("Encryptred01 : "+cipherText01);
        System.out.println("Encryptred02 : "+cipherText02);
        System.out.println("=====================================");
        String plainText01 = formatPreservingEncryption.decrypt(cipherText01, tweak);
        String plainText02 = formatPreservingEncryption.decrypt(cipherText02, tweak);
        System.out.println("Decryptred01 : "+plainText01);
        System.out.println("Decryptred02 : "+plainText02);
    }

    // Helper method to convert byte array to hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }
}
