/*
 * This common class is use for encrypt decrypt the password.
 */
package com.trt.mainproject.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author nilay
 */
public class CommonUtilJava {

    public static String encryptedPassword(String pass) {
        StringBuilder hash = new StringBuilder();

        MessageDigest sha;
        try {
            sha = MessageDigest.getInstance("SHA-1");

            byte[] hashedBytes = sha.digest(pass.getBytes());
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
            for (int idx = 0; idx < hashedBytes.length; ++idx) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            System.out.println(noSuchAlgorithmException.getMessage());
        }
        return hash.toString();
    }
}
