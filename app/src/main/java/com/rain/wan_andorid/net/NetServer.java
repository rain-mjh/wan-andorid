package com.rain.wan_andorid.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * retrofit
 */
public interface NetServer {
    //https://gank.io/api/v2/data/category/Girl/type/Girl/page/1/count/20
    //https://gank.io/category/Girl/type/Girl/page/1/count/20

    //干货集中营
    String baseURL="https://gank.io/";

    @GET("api/v2/data/category/Girl/type/Girl/page/{page}/count/{size}")
    Call<ResponseBody> getNewBook(@Path("page") int page , @Path("size") int size);

    //开发接口
    String OPEN_BASE_URL="http://poetry.apiopen.top";

    //玩安卓
    String api="https://wanandroid.com";

    //轮播图
    @GET("/banner/json")
    Call<ResponseBody> getBanner();

    //首页文章列表
    @GET("/article/list/{pageNum}/json")
    Call<ResponseBody> getArticleList(@Path("pageNum") int pageNum);

    //热门网站
    @GET("/friend/json")
    Call<ResponseBody>  getFriend();

    //项目分类
    @GET("/project/tree/json")
    Call<ResponseBody> getProject();

    //项目列表
    @GET("/project/list/{pageNum}/json")
    Call<ResponseBody> getProjectList(@Path("pageNum") int pageNum,@Query("cid") int cid);




    @GET("/wxarticle/chapters/json")
    Call<ResponseBody> getWabData();

    @GET("/wxarticle/list/{chapters_id}/{page}/json")
    Call<ResponseBody> getWxarticle(@Path("chapters_id") int chapters_id, @Path("page") int page);

    @GET("/sentences")
    Call<ResponseBody> getSentences();

}