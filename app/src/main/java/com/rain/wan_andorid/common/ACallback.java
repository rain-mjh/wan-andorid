package com.rain.wan_andorid.common;

/**
 * 数据返回
 */
public abstract class ACallback<T> {

   public abstract void onSuccess(T data);

   public abstract void onFail(int errCode,String errMsg);

}