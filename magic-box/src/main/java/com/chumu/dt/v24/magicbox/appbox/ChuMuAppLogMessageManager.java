package com.chumu.dt.v24.magicbox.appbox;


import com.chumu.dt.v24.magicbox.klog.ChuMuKLog;
/**

 * 主要功能： 系统日志输出工具类
 * @Prject: magic-box
 * @date: 2017年05月04日 14:13
 * @Copyright: 共有开源知识版权
 * @Company:
 * @version: v11-2.0.5-beta
 */
public class ChuMuAppLogMessageManager {
    //是否输出
    private static boolean isDebug = true;

    /*
     * 设置debug模式(true:打印日志  false：不打印)
     */
    public static void isEnableDebug(boolean isDebug){
        ChuMuAppLogMessageManager.isDebug = isDebug;
    }
    
    /**
     * 
     * @param tag
     * @param msg
     */
    public static void i(String tag,String msg){
        if(isDebug){
            ChuMuKLog.i(tag, msg != null ? msg : "");
        }
    }

    public static void i(Object object,String msg){
        if(isDebug){
            ChuMuKLog.i(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void i(String msg){
        if(isDebug){
            ChuMuKLog.i(" [INFO] --- ", msg != null ? msg : "");
        }
    }

    /**
     * 
     * @param tag
     * @param msg
     */
    public static void d(String tag,String msg){
        if(isDebug){
            ChuMuKLog.d(tag, msg != null ? msg : "");
        }
    }

    public static void d(Object object,String msg){
        if(isDebug){
            ChuMuKLog.d(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void d(String msg){
        if(isDebug){
            ChuMuKLog.d(" [DEBUG] --- ", msg != null ? msg : "");
        }
    }

    /**
     * 
     * @param tag
     * @param msg
     */
    public static void w(String tag,String msg){
        if(isDebug){
            ChuMuKLog.w(tag, msg != null ? msg : "");
        }
    }

    public static void w(Object object,String msg){
        if(isDebug){
            ChuMuKLog.w(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void w(String msg){
        if(isDebug){
            ChuMuKLog.w(" [WARN] --- ", msg != null ? msg : "");
        }
    }

    /**
     * 
     * @param tag
     * @param msg
     */
    public static void e(String tag,String msg){
        if(isDebug){
            ChuMuKLog.e(tag, msg !=null ? msg : "");
        }
    }

    public static void e(Object object,String msg){
        if(isDebug){
            ChuMuKLog.e(object.getClass().getSimpleName(), msg !=null ? msg : "");
        }
    }

    public static void e(String msg){
        if(isDebug){
            ChuMuKLog.e(" [ERROR] --- ", msg !=null ? msg : "");
        }
    }

    /**
     * 
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg){
        if(isDebug){
            ChuMuKLog.v(tag, msg != null ? msg : "");
        }
    }

    public static void v(Object object, String msg){
        if(isDebug){
            ChuMuKLog.v(object.getClass().getSimpleName(), msg != null ? msg : "");
        }
    }

    public static void v( String msg){
        if(isDebug){
            ChuMuKLog.v(" [VERBOSE] --- ", msg != null ? msg : "");
        }
    }
}