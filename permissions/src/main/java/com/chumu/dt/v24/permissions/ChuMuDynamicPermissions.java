package com.chumu.dt.v24.permissions;


import android.app.Activity;


import com.chumu.dt.v24.permissions.klog.ChuMuKLog;

import java.util.List;

import androidx.annotation.NonNull;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

public class ChuMuDynamicPermissions implements EasyPermissions.PermissionCallbacks, EasyPermissions.RationaleCallbacks {
    private int REQUEST_FILE_CODE = 99;

    private boolean flag = false;
    private Activity youActivity;
    String[] permissions;

    public ChuMuDynamicPermissions(Activity youActivity, String[] permissions) {
        this.youActivity = youActivity;
        this.permissions = permissions;
    }

    public boolean isFlag() {
        return flag;
    }

    public void init() {
        if (EasyPermissions.hasPermissions(youActivity, permissions)) {
            flag = true;

        } else {
            flag = false;
            EasyPermissions.requestPermissions(
                    new PermissionRequest.Builder(youActivity, REQUEST_FILE_CODE, permissions)
                            .setRationale("请确认相关权限！！")
                            .setPositiveButtonText("ok")
                            .setNegativeButtonText("cancal")
//                            .setTheme(R.style.my_fancy_style)
                            .build());
        }

    }

    @Override
    public void onRequestPermissionsResult(int i, @NonNull String[] strings, @NonNull int[] ints) {
        EasyPermissions.onRequestPermissionsResult(i, permissions, ints, this);
    }
    //    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        // Forward results to EasyPermissions
//
//    }

    private static final String TAG = "Share";

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
