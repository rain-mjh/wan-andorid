package com.rain.wan_andorid.base;

import android.app.Application;

import retrofit2.Retrofit;

public class MyApp  extends Application {
    public static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
    }


    public static Retrofit retrofit(String baseURL){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseURL)
                .build();
        return retrofit;
    }


    public static MyApp getInstance(){
        return myApp;
    }
}
