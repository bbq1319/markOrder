package kr.co.markncompany.markorder.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;

public class PasswordEncryption {

    private static final String RAW_KEY = "luxuryStar2022!@";

    public static String encryption(String password) throws Exception {
        // SHA-256 암호화
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        StringBuilder sb = new StringBuilder();
        for (byte b : md.digest()) {
            sb.append(String.format("%8s", Integer.toBinaryString(b)));
        }

        // openssl_encrypt
        byte[] ivBytes = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        Key keySpec = new SecretKeySpec(md.digest(RAW_KEY.getBytes(StandardCharsets.UTF_8)), "AES");

        // 암호화 시작
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(ivBytes));
        byte[] encrypted = c.doFinal(password.getBytes(StandardCharsets.UTF_8));

        String result = DatatypeConverter.printBase64Binary(encrypted);
        return result;
    }

    public static boolean mathes(String rawPassword, String encodedPassword) throws Exception {
        if (encryption(rawPassword).equals(encodedPassword))
            return true;
        else
            return false;
    }

}
