package com.chumu.dt.v24.permissions;

import android.annotation.SuppressLint;
import android.content.Context;


import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;


public class ChuMuGlide {
   public Context mContext;
    public static RequestOptions onGlideYj(int roundingRadius) {
    return RequestOptions.bitmapTransform(new RoundedCorners(roundingRadius));
    }
    @SuppressLint("CheckResult")
    public static RequestOptions onGlideYx() {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        return requestOptions;
    }
}
