package com.rain.wan_andorid.common;

/**
 *
 */
public  interface ResListener {
    void onSuccessPay(String code, String data);

    void onFailedPay(String code, String data);

}
