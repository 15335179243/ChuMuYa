package com.chumu.dt.v24.magicbox.swipeback.util;

import android.app.Activity;


import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;


/**
 * ChuMuYa
 * <p>
 * Created by ChuMu on 2020/8/4
 * Copyright © 2020年 ChuMu. All rights reserved.
 * <p>
 * Describe: 侧滑返回
 * @version: v11-2.0.5-beta
 */
public class SwipeBackListenerActivityAdapter implements SwipeBackLayout.SwipeListenerEx {
    private final WeakReference<Activity> mActivity;
    
    public SwipeBackListenerActivityAdapter(@NonNull Activity activity) {
        mActivity = new WeakReference<>(activity);
    }
    
    @Override
    public void onScrollStateChange(int state, float scrollPercent) {
    
    }
    
    @Override
    public void onEdgeTouch(int edgeFlag) {
        Activity activity = mActivity.get();
        if (null != activity) {
            SwipeBackUtil.convertActivityToTranslucent(activity);
        }
    }
    
    @Override
    public void onScrollOverThreshold() {
    
    }
    
    @Override
    public void onContentViewSwipedBack() {
        Activity activity = mActivity.get();
        if (null != activity && !activity.isFinishing()) {
            activity.finish();
            activity.overridePendingTransition(0, 0);
        }
    }
}