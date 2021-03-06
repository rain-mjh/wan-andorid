package com.rain.wan_andorid.fragment.home;

import android.content.Intent;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rain.wan_andorid.R;
import com.rain.wan_andorid.activity.web.WebActivity;
import com.rain.wan_andorid.adapter.ArticleAdapter;
import com.rain.wan_andorid.base.BaseFragment;
import com.rain.wan_andorid.entity.ArticleEntity;
import com.rain.wan_andorid.fragment.home.presenter.HomePresernterCompl;
import com.rain.wan_andorid.fragment.home.view.IHomeView;
import com.rain.wan_andorid.utils.banner.BannerCreate;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;

import java.util.List;

public class HomeFragment  extends BaseFragment implements IHomeView {

    Banner banner;

    HomePresernterCompl homePresernterCompl;

    RecyclerView recyclerView;

    ArticleAdapter articleAdapter;

    int page=0;

    SmartRefreshLayout smartRefreshLayout;

    List<ArticleEntity.DataBean.DatasBean> articleList;

    @Override
    protected int setContentView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void startLoad() {
        homePresernterCompl.getBanner();
        homePresernterCompl.getArticleList(page);
    }

    @Override
    protected void initData() {
        banner=findViewById(R.id.banner);

        recyclerView=findViewById(R.id.recycleview);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        homePresernterCompl=new HomePresernterCompl(this);

        articleAdapter=new ArticleAdapter(R.layout.list_item_home,articleList,this);

        recyclerView.setAdapter(articleAdapter);
        smartRefreshLayout=findViewById(R.id.refreshLayout);
        smartRefreshLayout.setEnableAutoLoadMore(true);//????????????????????????????????????????????????????????????
        smartRefreshLayout.setEnableLoadMore(true);//??????????????????????????????
        smartRefreshLayout.setEnableRefresh(true);//??????????????????????????????

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 0;
                homePresernterCompl.getArticleList(page);
                refreshLayout.finishRefresh(1000);//??????????????????
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                homePresernterCompl.getArticleList(page);
                refreshLayout.finishLoadMore(1000);
            }
        });
    }



    @Override
    public void getBannerList(List<String> imageList, List<String> titleList) {
        Log.e("xxx",imageList.size()+" "+titleList.size());
        BannerCreate.setDefault(banner, imageList, 5000,titleList);
    }

    @Override
    public void getBannerFail(int code, String msg) {

    }


    @Override
    public void getArticleList(ArticleEntity.DataBean articleEntityList) {

        List<ArticleEntity.DataBean.DatasBean>   datasBeanList=articleEntityList.getDatas();
           if (datasBeanList.size()>0){
               Log.e("xxx",datasBeanList.size()+"??????");
               if (page>0){
                   for (ArticleEntity.DataBean.DatasBean data:datasBeanList){
                       articleList.add(data);
                   }
               }else {
                   articleList=datasBeanList;
               }
               articleAdapter.replaceData(articleList);
               articleAdapter.notifyDataSetChanged();
           }else {
               Toast.makeText(getContext(),"?????????????????????",Toast.LENGTH_SHORT).show();
           }
    }

    @Override
    public void goToWeb(String link) {

        Intent intent=new Intent(getContext(), WebActivity.class);

        intent.putExtra("link",link);

        startActivity(intent);
    }
}
