package com.chumu.dt.v24.permissions.klog.base;

/**
 * @Description:主要功能:
 * @Prject: ChuMuYa
 * @date: 2017年05月16日 16:55
 * @Copyright: 个人版权所有
 * @Company:
 * @version: 1.0.0
 */


import android.util.Log;

import com.chumu.dt.v24.permissions.klog.ChuMuKLog;

/**
 * Created by zhaokaiqiang on 15/11/18.
 */
public class ChuMuBaseLog {

    private static final int MAX_LENGTH = 4000;

    public static void printDefault(int type, String tag, String msg) {

        int index = 0;
        int length = msg.length();
        int countOfSub = length / MAX_LENGTH;

        if (countOfSub > 0) {
            for (int i = 0; i < countOfSub; i++) {
                String sub = msg.substring(index, index + MAX_LENGTH);
                printSub(type, tag, sub);
                index += MAX_LENGTH;
            }
            printSub(type, tag, msg.substring(index, length));
        } else {
            printSub(type, tag, msg);
        }
    }

    private static void printSub(int type, String tag, String sub) {
        switch (type) {
            case ChuMuKLog.V:
                Log.v(tag, sub);
                break;
            case ChuMuKLog.D:
                Log.d(tag, sub);
                break;
            case ChuMuKLog.I:
                Log.i(tag, sub);
                break;
            case ChuMuKLog.W:
                Log.w(tag, sub);
                break;
            case ChuMuKLog.E:
                Log.e(tag, sub);
                break;
            case ChuMuKLog.A:
                Log.wtf(tag, sub);
                break;
        }
    }

}
