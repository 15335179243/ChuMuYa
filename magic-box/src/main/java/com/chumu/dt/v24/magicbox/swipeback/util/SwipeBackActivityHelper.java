package com.chumu.dt.v24.magicbox.swipeback.util;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;

import com.chumu.dt.v24.magicbox.R;



/**
 * ChuMuYa
 * <p>
 * Created by ChuMu on 2020/8/4
 * Copyright © 2020年 ChuMu. All rights reserved.
 * <p>
 * Describe: 侧滑返回
 * @version: v11-2.0.6-beta
 */
public class SwipeBackActivityHelper {
    private Activity mActivity;
    
    private SwipeBackLayout mSwipeBackLayout;
    
    public SwipeBackActivityHelper(Activity activity) {
        mActivity = activity;
    }
    

    public void onActivityCreate() {
        mActivity.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mActivity.getWindow().getDecorView().setBackgroundDrawable(null);
        mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(mActivity).inflate(
                R.layout.swipeback_layout, null);
    }
    
    public void onPostCreate() {
        mSwipeBackLayout.attachToActivity(mActivity);
    }
    
    public View findViewById(int id) {
        if (mSwipeBackLayout != null) {
            return mSwipeBackLayout.findViewById(id);
        }
        return null;
    }
    
    public SwipeBackLayout getSwipeBackLayout() {
        return mSwipeBackLayout;
    }
}