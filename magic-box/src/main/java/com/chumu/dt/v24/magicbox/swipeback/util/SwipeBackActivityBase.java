package com.chumu.dt.v24.magicbox.swipeback.util;

/**
 * ChuMuYa
 * <p>
 * Created by ChuMu on 2020/8/4
 * Copyright © 2020年 ChuMu. All rights reserved.
 * <p>
 * Describe: 侧滑返回
 * @version: 2.0.3-beta
 */
public interface SwipeBackActivityBase {
    /**
     * @return the SwipeBackLayout associated with this activity.
     */
      SwipeBackLayout getSwipeBackLayout();
    
      void setSwipeBackEnable(boolean enable);
    
    /**
     * Scroll out contentView and finish the activity
     */
      void scrollToFinishActivity();
    
}
