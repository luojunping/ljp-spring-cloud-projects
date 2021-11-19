package com.ljp.test.rsa;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class RSATest {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] jiami = cipher.doFinal("hello world !!! 中国北京！！！".getBytes());
        String jiamiStr = Base64.getEncoder().encodeToString(jiami);
        System.out.println("jiamiStr = " + jiamiStr);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] jiemi = cipher.doFinal(Base64.getDecoder().decode(jiamiStr));
        System.out.println(new String(jiemi, StandardCharsets.UTF_8));
    }

}
