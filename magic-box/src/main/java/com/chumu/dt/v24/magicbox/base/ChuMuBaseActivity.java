package com.chumu.dt.v24.magicbox.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chumu.dt.v24.magicbox.swipeback.ChuMuSwipeBack;
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
 * Describe: 主要是用来侧滑返回的功能
 * @version: 2.0.3-beta
 */


public class ChuMuBaseActivity extends AppCompatActivity implements SwipeBackActivityBase {

    private SwipeBackActivityHelper mHelper;

    //加载注解设置
    private void initAttributes() {
        ChuMuSwipeBack chuMuSwipeBack = getClass().getAnnotation(ChuMuSwipeBack.class);
        mHelper.onActivityCreate();
        if (chuMuSwipeBack != null) {
            setSwipeBackEnable(chuMuSwipeBack.value());
        } else {
            setSwipeBackEnable(false);
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        initAttributes();

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


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }


}
