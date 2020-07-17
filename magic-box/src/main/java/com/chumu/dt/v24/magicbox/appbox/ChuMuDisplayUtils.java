package com.chumu.dt.v24.magicbox.appbox;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
/**
 * 主要功能： 手机常用单位转换的辅助类及屏显示相关
 *
 * @Prject: magic-box
 * @Package: com.chumu.dt.v24.magicbox.appbox
 * @author: ChuMuYa
 * @date: 2017年05月03日 16:37
 * @Copyright: 个人版权所有
 * @Company:
 @version: 2.0.1-beta
 */

public class ChuMuDisplayUtils {
    @SuppressLint("StaticFieldLeak")
    private static Context sContext;
    
    public static void init(Context context) {
        if(null != context) {
            sContext = context.getApplicationContext();
        }
    }
    
    private static void checkNullContext() {
        if (null == sContext) {
            throw new RuntimeException("ChuMuAppUtils...context is null, 请在init方法中传入context");
        }
    }
    
    public static int getScreenHeight() {
        checkNullContext();
        DisplayMetrics dm = sContext.getResources().getDisplayMetrics();;
        if(Build.VERSION.SDK_INT > 16) {
            //适配全面屏幕（包括虚拟功能高度）
            WindowManager wm = (WindowManager) sContext.getSystemService(Context.WINDOW_SERVICE);
            if(null != wm) {
                Display display = wm.getDefaultDisplay();
                dm = new DisplayMetrics();
                display.getRealMetrics(dm);
            }
        }
        return dm.heightPixels;
    }
    
    public static int getScreenWidth() {
        checkNullContext();
        return sContext.getResources().getDisplayMetrics().widthPixels;
    }
    
    public static int getScreenWidthDp() {
        checkNullContext();
        return px2dp(getScreenWidth());
    }
    
    public static int getScreenHeightDp() {
        checkNullContext();
        return px2dp(getScreenHeight());
    }
    
    public static int dp2px(float dpValue) {
        final float scale = getDensity();
        return (int) (dpValue * scale + 0.5f);
    }
    
    public static int px2dp(float pxValue) {
        final float scale = getDensity();
        return (int) (pxValue / scale + 0.5f);
    }
    
    public static int px2sp(float pxValue) {
        final float scale = getDensity();
        return (int) (pxValue / scale + 0.5f);
    }
    
    public static int sp2px(float spValue) {
        final float scale = getDensity();
        return (int) (spValue * scale + 0.5f);
    }
    
    public static int getDpi() {
        checkNullContext();
        return sContext.getResources().getDisplayMetrics().densityDpi;
    }
    
    public static float getDensity() {
        checkNullContext();
        return sContext.getResources().getDisplayMetrics().density;
    }
    
    /**
     * 获取状态栏高度
     */
    public static int getStatusBarHeight() {
        checkNullContext();
        // 默认为38
        int height = 38;
        //获取status_bar_height资源的ID
        int resourceId = sContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            height = sContext.getResources().getDimensionPixelSize(resourceId);
        Log.e("Hubert", "状态栏的高度:" + height);
        return height;
    }
    
    /**
     * 虚拟操作拦（home等）是否显示
     */
    public static boolean isNavigationBarShow(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Display display = activity.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            Point realSize = new Point();
            display.getSize(size);
            display.getRealSize(realSize);
            return realSize.y != size.y;
        } else {
            boolean menu = ViewConfiguration.get(activity).hasPermanentMenuKey();
            boolean back = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
            if (menu || back) {
                return false;
            } else {
                return true;
            }
        }
    }
    
    /**
     * 获取虚拟操作拦（home等）高度
     */
    public static int getNavigationBarHeight(Activity activity) {
        if (!isNavigationBarShow(activity))
            return 0;
        int height = 0;
        Resources resources = activity.getResources();
        //获取NavigationBar的高度
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0)
            height = resources.getDimensionPixelSize(resourceId);
        Log.e("Hubert", "NavigationBar的高度:" + height);
        return height;
    }
    
}
