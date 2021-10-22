package com.rain.wan_andorid.fragment.home.model;

import com.rain.wan_andorid.common.ACallback;

public interface IHome {

    /**
     * 轮播图
     */
    void getBanner(ACallback<String> callback);

    /**
     * 首页推荐文章列表
     */

    void getArticleList(int pageNum, ACallback<String> callback);



}
