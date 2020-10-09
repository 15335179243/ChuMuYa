package com.chumu.dt.v24.magicbox.encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Description:主要功能:DES对称加密（Data Encryption Standard，数据加密标准，对称加密算法）
 * @Prject: magic-box
 * @date: 2017年05月16日 15:56
 * @Copyright: 共有开源知识版权
 * @Company:
 * @version: v11-2.0.6-beta
 */

public class ChuMuDESUtils {

    private ChuMuDESUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /*
     * 生成密钥
     */
    public static byte[] initKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56);
        SecretKey secretKey = keyGen.generateKey();
        return secretKey.getEncoded();
    }

    /*
     * DES 加密
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "DES");

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = cipher.doFinal(data);
        return cipherBytes;
    }

    /*
     * DES 解密
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, "DES");

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] plainBytes = cipher.doFinal(data);
        return plainBytes;
    }

}
