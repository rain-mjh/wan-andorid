package com.rain.wan_andorid.fragment.chapter.model;

import com.rain.wan_andorid.base.MyApp;
import com.rain.wan_andorid.common.ACallback;
import com.rain.wan_andorid.net.NetServer;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterModel implements IChapter {

    @Override
    public void getChapterList(ACallback<String> aCallback) {
        Call<ResponseBody> call = MyApp.retrofit(NetServer.api).create(NetServer.class).getChaptersList();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code()==200){
                    try {
                        String body=response.body().string();
                        aCallback.onSuccess(body);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    aCallback.onFail(500,response.message());
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                 aCallback.onFail(500,t.getMessage());
            }
        });
    }

}
