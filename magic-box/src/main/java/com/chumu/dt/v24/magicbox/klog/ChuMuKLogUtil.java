package com.chumu.dt.v24.magicbox.klog;

/**
 * @Description:主要功能:
 * @Prject: magic-box
 * @date: 2017年05月16日 16:54
 * @Copyright: 个人版权所有
 * @Company:
 @version: 2.0.1-beta
 */

import android.text.TextUtils;


/**
 * Created byChuMU on 15/12/11.
 */
public class ChuMuKLogUtil {

    public static boolean isEmpty(String line) {
        return TextUtils.isEmpty(line) || line.equals("\n") || line.equals("\t") || TextUtils.isEmpty(line.trim());
    }

    public static void printLine(String tag, boolean isTop) {
        if (isTop) {
         ChuMuKLog.d(tag, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
          ChuMuKLog.d(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }

}