package com.chumu.dt.v24.permissions;


public interface ChuMuView<T>{
    void onSuccess(T datas);
    void onFail(String msg);
}
