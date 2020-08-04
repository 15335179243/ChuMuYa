package com.chumu.dt.v24.magicbox.appbox;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * ChuMuYa
 * <p>
 * Created by ChuMu on 2020/8/4
 * Copyright © 2020年 ChuMu. All rights reserved.
 * <p>
 * Describe: 动态权限获取
 * @version: 2.0.2-bet
 * 开源库（https://github.com/permissions-dispatcher/PermissionsDispatcher 注解方式）
 * 开源库（https://github.com/tbruyelle/RxPermissions ）
 */
public class ChuMuPermission {

    public static final int RequestCode_Permission = 100;


    public Activity mContext;
    private ChuMuPermission mChuMuPermission;

    private ChuMuPermission(Activity context) {
        mContext = context;
    }

    public ChuMuPermission getInstance(Activity context) {
        if (mChuMuPermission == null) {
            mChuMuPermission = new ChuMuPermission(context);
        }
        return mChuMuPermission;
    }

    /**
     * 申请结果回调
     * 在Activity的onRequestPermissionsResult中调用
     */
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults, PermissionsResultListener listener) {
        if (requestCode == RequestCode_Permission) {
            ArrayList<String> listSuccess = new ArrayList<>();
            ArrayList<String> listFailure = new ArrayList<>();
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    listSuccess.add(permissions[i]);

                } else {
                    listFailure.add(permissions[i]);
                }
            }

            if (listSuccess.size() > 0)
                listener.onRequestPermissionSuccess(listSuccess.toArray(new String[listSuccess.size()]));
            if (listFailure.size() > 0)
                listener.onRequestPermissionFailure(listFailure.toArray(new String[listFailure.size()]));
        }
    }


    /**
     * 请求权限
     * <p>
     * 警告：此处除了用户拒绝外，唯一可能出现无法获取权限或失败的情况是在AndroidManifest.xml中未声明权限信息
     * Android6.0+即便需要动态请求权限（重点）但不代表着不需要在AndroidManifest.xml中进行声明。
     *
     * @param permissions 请求的权限
     * @param listeners   回调监听器
     */
    public void requestPermission(String[] permissions, PermissionsResultListener listeners) {
        listener = listeners;
        if (checkPermissions(permissions)) {
            if (listeners != null) {
                listeners.onRequestPermissionSuccess(permissions);
            }
        } else {
            List<String> needPermissions = getDeniedPermissions(permissions);
            ActivityCompat.requestPermissions(mContext, needPermissions.toArray(new String[needPermissions.size()]), RequestCode_Permission);
        }
    }

    /**
     * 检测所有的权限是否都已授权
     *
     * @param permissions
     * @return
     */
    public boolean checkPermissions(String[] permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(mContext, permission) !=
                    PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    //单权限检查
    public boolean checkPermissions(String permission) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(mContext, permission) !=
                PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    /**
     * 获取权限集中需要申请权限的列表
     *
     * @param permissions
     * @return
     */
    private List<String> getDeniedPermissions(String[] permissions) {
        List<String> needRequestPermissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(mContext, permission) !=
                    PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.shouldShowRequestPermissionRationale(mContext, permission)) {
                needRequestPermissionList.add(permission);
            }
        }
        return needRequestPermissionList;
    }


    /**
     * 确认所有的权限是否都已授权
     *
     * @param grantResults
     * @return
     */
    private boolean verifyPermissions(int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 显示提示对话框需要的时候手动调用
     */
    private void showTipsDialog() {
        new AlertDialog.Builder(mContext)
                .setTitle("警告")
                .setMessage("需要必要的权限才可以正常使用该功能，您已拒绝获得该权限。\n如果需要重新授权，您可以点击“允许”按钮进入系统设置进行授权")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ChuMuPermissionTools.init(mContext).jumpPermissionPage();
                    }
                }).show();
    }

    public interface PermissionsResultListener {
        void onRequestPermissionSuccess(String[] permission);

        void onRequestPermissionFailure(String... permission);
    }

    public PermissionsResultListener listener;

}
