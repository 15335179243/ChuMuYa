package com.chumu.dt.v24.permissions;

public interface ChuMuCallback<T> {
    void  onSucceess(T data);
    void onFailed(String errre);
}
