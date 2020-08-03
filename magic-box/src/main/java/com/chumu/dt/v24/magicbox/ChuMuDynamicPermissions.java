package com.chumu.dt.v24.magicbox;


import android.app.Activity;


import com.chumu.dt.v24.magicbox.klog.ChuMuKLog;

import java.util.List;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

/****
 * 待测试是否实用
 * */

public class ChuMuDynamicPermissions implements EasyPermissions.PermissionCallbacks, EasyPermissions.RationaleCallbacks {
    private int REQUEST_FILE_CODE = 99;

    private boolean flag = false;
    private Activity youActivity;
    private String[] permissions;
    private volatile static ChuMuDynamicPermissions mChuMuDynamicPermissions;
    private int theme;
    private String rationale="请确认相关权限！！";
    private String positiveButtonText="确认";
    private String negativeButtonText="取消";

    private ChuMuDynamicPermissions() {
        throw new IllegalArgumentException("u can't instantiate me...");
    }

    public ChuMuDynamicPermissions setRationale(String rationale) {
        this.rationale = rationale;
        return mChuMuDynamicPermissions;
    }

    public ChuMuDynamicPermissions setPositiveButtonText(String positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
        return mChuMuDynamicPermissions;
    }

    public ChuMuDynamicPermissions setNegativeButtonText(String negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
        return mChuMuDynamicPermissions;
    }

    public synchronized static ChuMuDynamicPermissions getInstance() {
        if (mChuMuDynamicPermissions == null) {
            synchronized (ChuMuDynamicPermissions.class) {
                if (mChuMuDynamicPermissions == null) {
                    mChuMuDynamicPermissions = new ChuMuDynamicPermissions();
                }
            }

        }
        return mChuMuDynamicPermissions;
    }

    public boolean setPermissions(Activity youActivity, String[] permissions) {

        return setPermissions(youActivity, permissions, R.style.chu_mu_dialog_ui_anim);
    }

    public boolean setPermissions(Activity youActivity, String[] permissions, @StyleRes int themeId) {
        this.youActivity = youActivity;
        this.permissions = permissions;
        theme = themeId;
        init();
        return isFlag();
    }

    public boolean isFlag() {
        return flag;
    }

    private void init() {
        if (EasyPermissions.hasPermissions(youActivity, permissions)) {
            flag = true;

        } else {
            flag = false;
            EasyPermissions.requestPermissions(
                    new PermissionRequest.Builder(youActivity, REQUEST_FILE_CODE, permissions)
                            .setRationale(rationale)
                            .setPositiveButtonText(positiveButtonText)
                            .setNegativeButtonText(negativeButtonText)
                            .setTheme(theme)
                            .build());
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private static final String TAG = "======================权限请求=========================";

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        flag = true;
        ChuMuKLog.d(TAG, "onPermissionsGranted: 用户接受确认权限");

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

        flag = false;
        ChuMuKLog.d(TAG, "onPermissionsDenied: 用户拒绝权限确认");
    }

    @Override
    public void onRationaleAccepted(int requestCode) {

        ChuMuKLog.d(TAG, "onRationaleAccepted: ");
    }

    @Override
    public void onRationaleDenied(int requestCode) {

        ChuMuKLog.d(TAG, "onRationaleDenied: ");
        //结束
    }
}
