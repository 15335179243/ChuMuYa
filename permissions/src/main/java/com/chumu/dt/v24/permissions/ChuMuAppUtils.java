package com.chumu.dt.v24.permissions;

import android.annotation.SuppressLint;
import android.content.Context;

/**
 * @Description:主要功能:初始化在application中获取context
 * @Package ChuMuYa
 * @date: 2017年05月19日 14:09
 * @Copyright: 个人版权所有
 * @Company:
 * @version: 1.0.0
 */

public class ChuMuAppUtils {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    private ChuMuAppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        ChuMuAppUtils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }
}
