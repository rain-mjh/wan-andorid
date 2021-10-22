package com.rain.wan_andorid.fragment.home.view;

import com.rain.wan_andorid.entity.ArticleEntity;

import java.util.List;

public interface IHomeView {

    void getBannerList(List<String> imageList,List<String> titleList);

    void getBannerFail(int code,String msg);

    void getArticleList(ArticleEntity.DataBean articleEntityList);

    void goToWeb(String link);
}
