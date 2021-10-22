package com.rain.wan_andorid.fragment.home.presenter;

import com.rain.wan_andorid.common.ACallback;

public interface IHomePresenter {
    /**
     * 轮播图
     */
    void getBanner();

    /**
     * 首页推荐文章列表
     */

    void getArticleList(int pageNum);
}
