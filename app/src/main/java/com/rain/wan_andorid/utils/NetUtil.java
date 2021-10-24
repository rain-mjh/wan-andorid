package com.rain.wan_andorid.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class NetUtil {
    /**
     * 无网络
     */
    public static final int NETWORK_NONE = -1;

    /**
     * 移动网络
     */
    public static final int NETWORK_MOBILE = 0;

    /**
     * WIFI
     */
    public static final int NETWORK_WIFI = 1;

    public static final int NETWORK_ETHERNET = 2;

    /**
     * 获取当前网络状态
     * @param context
     * @return
     */
    public static int getNetworkState(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()){
            if (info.getType() == ConnectivityManager.TYPE_MOBILE){
                return NETWORK_MOBILE;
            }else if (info.getType() == ConnectivityManager.TYPE_WIFI){
                return NETWORK_WIFI;
            }else if (info.getType() == ConnectivityManager.TYPE_ETHERNET){
                return NETWORK_ETHERNET;
            }
        }else{
            return NETWORK_NONE;
        }
        return NETWORK_NONE;
    }
}
