package com.chumu.dt.v24.magicbox.appbox;

/**
 * ChuMuYa
 * <p>
 * Created by ChuMu on 2020/8/14
 * Copyright © 2020年 ChuMu. All rights reserved.
 * <p>
 * Describe 没有登录抛出的异常:
 */

public  class NotSignException  extends RuntimeException{

    public NotSignException(String e) {
        super(e);
    }
}
