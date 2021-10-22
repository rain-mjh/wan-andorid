package com.rain.wan_andorid.fragment.project.ui.model;

import android.util.Log;

import com.rain.wan_andorid.base.MyApp;
import com.rain.wan_andorid.common.ACallback;
import com.rain.wan_andorid.net.NetServer;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectItemModel implements IProjectItem{

    @Override
    public void getProjectList(int page, int cid, ACallback<String> callback) {
        Call<ResponseBody> call = MyApp.retrofit(NetServer.api).create(NetServer.class).getProjectList(page, cid);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code()==200){
                    try {
                        String body=response.body().string();
                        callback.onSuccess(body);

                        Log.e("xxx",response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    callback.onFail(response.code(),response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onFail(500,t.getMessage());
            }
        });
    }

}
