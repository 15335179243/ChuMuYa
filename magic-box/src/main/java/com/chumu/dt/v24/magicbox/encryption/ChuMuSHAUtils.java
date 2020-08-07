package com.chumu.dt.v24.magicbox.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description:主要功能:SHA-1 加密 不可逆（Secure Hash Algorithm，安全散列算法）
 * @Prject: magic-box
 * @date: 2017年05月16日 15:57
 * @Copyright: 共有开源知识版权
 * @Company:
 * @version: v11-2.0.4-beta
 */

public class ChuMuSHAUtils {

    private ChuMuSHAUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * SHA-512 加密
     * @param data
     * @return
     */
    public static String encryptSHA(byte[] data) {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA-512");
            sha.update(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] resultBytes = sha.digest();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < resultBytes.length; i++) {
            if (Integer.toHexString(0xFF & resultBytes[i]).length() == 1) {
                builder.append("0").append(
                    Integer.toHexString(0xFF & resultBytes[i]));
            } else {
                builder.append(Integer.toHexString(0xFF & resultBytes[i]));
            }
        }
        return builder.toString();
    }

}
