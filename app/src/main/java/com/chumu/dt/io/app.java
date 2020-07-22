package com.chumu.dt.io;

import android.app.Application;

import com.chumu.dt.v24.magicbox.appbox.ChuMuAppUtils;

public class app extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ChuMuAppUtils.init(this);
    }
}
