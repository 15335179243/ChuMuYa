package com.chumu.dt.v24.magicbox.swipeback;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import com.chumu.dt.v24.magicbox.swipeback.util.SwipeBackActivityBase;
import com.chumu.dt.v24.magicbox.swipeback.util.SwipeBackActivityHelper;
import com.chumu.dt.v24.magicbox.swipeback.util.SwipeBackLayout;
import com.chumu.dt.v24.magicbox.swipeback.util.SwipeBackUtil;


/**
 * ChuMuYa
 * <p>
 * Created by ChuMu on 2020/8/4
 * Copyright © 2020年 ChuMu. All rights reserved.
 * <p>
 * Describe: 侧滑返回
 *
 * @version: v11-2.0.4-beta
 */
public class ChuMuSwipeBackActivity extends AppCompatActivity implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        SwipeBackUtil.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
