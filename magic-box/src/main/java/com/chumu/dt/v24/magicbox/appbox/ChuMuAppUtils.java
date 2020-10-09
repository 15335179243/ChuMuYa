package com.chumu.dt.v24.magicbox.appbox;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.chumu.dt.v24.magicbox.klog.ChuMuKLog;
import com.chumu.dt.v24.magicbox.klog.ChuMuKLogUtil;

/**
 * @Description:主要功能:初始化在application中获取context
 *  @Prject: magic-box
 * @date: 2017年05月19日 14:09
 * @Copyright: 共有开源知识版权
 * @Company:
 * @version: v11-2.0.6-beta
 */

public class ChuMuAppUtils extends Application {
    private static Context context;

    private ChuMuAppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(final Context context) {
        if (context!=null) {
            ChuMuAppUtils.context = context.getApplicationContext();
            ChuMuDisplayUtils.init(context);
                    for (int i = 0; i < 2; i++) {
                        ChuMuKLogUtil.printLine(context.getPackageName(), true);
                        ChuMuKLog.e(context.getPackageName(), "\t" + "欢迎使用ChuMu(快速开发工具包)" + "\n" + "载入正常,如有什么使用问题,欢迎GitHub留言,项目地址  : https://github.com/15335179243/ChuMuYa" +
                                "\n" + "感谢您的意见和反馈,祝您生活愉快!!!");
                        ChuMuKLogUtil.printLine(context.getPackageName(), false);
                    }

        }else {
            throw new NullPointerException("Please pass into the context");
        }
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
