package com.chumu.dt.v24.permissions;

import android.annotation.SuppressLint;
import android.content.Context;


import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;


public class ChuMuGlide {

    public static RequestOptions onGlideYj(int roundingRadius) {
        RoundedCorners roundedCorners = new RoundedCorners(roundingRadius);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);
        return options;
    }

    public static RequestOptions onGlideYj(int roundingRadius,int overWidth,int overHeiggt) {
        RoundedCorners roundedCorners = new RoundedCorners(roundingRadius);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
         RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(overWidth, overHeiggt);

        return options;
    }
    @SuppressLint("CheckResult")
    public static RequestOptions onGlideYx() {
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        return requestOptions;
    }
}

