package com.chumu.dt.v24.magicbox.encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

/**
 * @Description:主要功能:3DES对称加密（Triple DES、DESede，进行了三重DES加密的算法，对称加密算法）
 * @Prject: magic-box
 * @date: 2017年05月16日 15:58
 * @Copyright: 共有开源知识版权
 * @Company:
 * @version: v11-2.0.5-beta
 */

public class ChuMuTripleDESUtils {

    private ChuMuTripleDESUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /*
     * 生成密钥
     */
    public static byte[] initKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
        keyGen.init(168);  //112 168
        SecretKey secretKey = keyGen.generateKey();
        return secretKey.getEncoded();
    }

    /*
     * 3DES 加密
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "DESede");

        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = cipher.doFinal(data);
        return cipherBytes;
    }

    /*
     * 3DES 解密
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "DESede");

        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] plainBytes = cipher.doFinal(data);
        return plainBytes;
    }

}
