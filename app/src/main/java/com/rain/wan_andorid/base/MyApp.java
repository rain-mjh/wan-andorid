package com.rain.wan_andorid.base;

import android.app.Application;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import retrofit2.Retrofit;

public class MyApp  extends Application {
    public static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;

        initBugly();
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

    private void initBugly() {
        Beta.showInterruptedStrategy = true;

        Bugly.init(getApplicationContext(), "0c4b909568", true);
    }

}
