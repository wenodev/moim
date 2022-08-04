package com.example.moim.utils;

import com.example.moim.common.CipherAlgorithmException;
import com.example.moim.common.ErrorMessage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CipherGenerator {
    private final static String SHA_512 = "SHA-512";

    public static String encode(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(SHA_512);
        } catch (NoSuchAlgorithmException e) {
            throw new CipherAlgorithmException(ErrorMessage.CIPHER_ALGORITHM_NOT_FOUND);
        }

        byte byteData[] = messageDigest.digest(password.getBytes());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if(hex.length() == 1) stringBuffer.append('0');
            stringBuffer.append(hex);
        }

        return stringBuffer.toString();
    }
}
