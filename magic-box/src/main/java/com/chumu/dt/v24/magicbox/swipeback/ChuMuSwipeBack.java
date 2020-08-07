package com.chumu.dt.v24.magicbox.swipeback;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * ChuMuYa
 * <p>
 * Created by ChuMu on 2020/8/4
 * Copyright © 2020年 ChuMu. All rights reserved.
 * <p>
 * Describe: 侧滑返回
 * @version: v11-2.0.4-beta
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChuMuSwipeBack {
    boolean value() default false;
}
