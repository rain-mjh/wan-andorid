package com.rain.wan_andorid.fragment.home.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.rain.wan_andorid.common.ACallback;
import com.rain.wan_andorid.entity.ArticleEntity;
import com.rain.wan_andorid.entity.BannerEntity;
import com.rain.wan_andorid.entity.BaseEntity;
import com.rain.wan_andorid.fragment.home.model.HomeModel;
import com.rain.wan_andorid.fragment.home.model.IHome;
import com.rain.wan_andorid.fragment.home.view.IHomeView;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

public class HomePresernterCompl implements IHomePresenter {

    IHome iHome;

    IHomeView iHomeView;

    public HomePresernterCompl( IHomeView iHomeView) {
       this.iHomeView=iHomeView;

        iHome=new HomeModel();
    }

    @Override
    public void getBanner() {
        iHome.getBanner(new ACallback<String>() {
            @Override
            public void onSuccess(String data) {
                BannerEntity entity=new Gson().fromJson(data,BannerEntity.class);
                if(entity.getErrorCode()==0){
                    List<BannerEntity.DataBean> dataBeanList = entity.getData();

                    List<String> imageList=new ArrayList();
                    List<String> titleList=new ArrayList<>();

                    for (BannerEntity.DataBean dataBean:dataBeanList){
                        imageList.add(dataBean.getImagePath());
                        titleList.add(dataBean.getTitle());
                    }
                    iHomeView.getBannerList(imageList,titleList);
                }else {
                    iHomeView.getBannerFail(500,entity.getErrorMsg());
                }

            }
            @Override
            public void onFail(int errCode, String errMsg) {
                iHomeView.getBannerFail(500,errMsg);
            }
        });
    }

    @Override
    public void getArticleList(int pageNum) {
       iHome.getArticleList(pageNum, new ACallback<String>() {
           @Override
           public void onSuccess(String data) {
             //  Log.e("xxx",data);

               ArticleEntity articleEntity=new Gson().fromJson(data, ArticleEntity.class);
               iHomeView.getArticleList(articleEntity.getData());

           }

           @Override
           public void onFail(int errCode, String errMsg) {

           }
       });
    }
}
