package com.chumu.dt.v24.magicbox.klog.base;

/**
 * @Description:主要功能:
 * @Prject: magic-box
 * @date: 2017年05月16日 16:56
 * @Copyright: 共有开源知识版权
 * @Company:
 * @version: v11-2.0.4-beta
 */



import android.util.Log;

import com.chumu.dt.v24.magicbox.klog.ChuMuKLog;
import com.chumu.dt.v24.magicbox.klog.ChuMuKLogUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ChuMu on 15/11/18.
 */
public class JsonLog {

    public static void printJson(String tag, String msg, String headString) {

        String message;

        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(ChuMuKLog.JSON_INDENT);
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(ChuMuKLog.JSON_INDENT);
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }

        ChuMuKLogUtil.printLine(tag, true);
        message = headString + ChuMuKLog.LINE_SEPARATOR + message;
        String[] lines = message.split(ChuMuKLog.LINE_SEPARATOR);
        for (String line : lines) {
            Log.d(tag, "║ " + line);
        }
        ChuMuKLogUtil.printLine(tag, false);
    }
}
