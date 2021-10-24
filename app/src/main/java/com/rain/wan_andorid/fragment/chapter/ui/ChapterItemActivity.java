package com.rain.wan_andorid.fragment.chapter.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.rain.wan_andorid.R;
import com.rain.wan_andorid.activity.web.WebActivity;
import com.rain.wan_andorid.adapter.ProjectItemAdapter;
import com.rain.wan_andorid.entity.ChapterItemEntity;
import com.rain.wan_andorid.entity.ProjectItemEntity;
import com.rain.wan_andorid.fragment.chapter.adapter.ChapterItemAdapter;
import com.rain.wan_andorid.fragment.chapter.ui.presenter.ChapterPresenterComl;
import com.rain.wan_andorid.fragment.chapter.ui.view.IChapterItemView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.List;

public class ChapterItemActivity extends AppCompatActivity  implements IChapterItemView {

    int cid;

    int page=0;

    ChapterItemAdapter adapter;

    ChapterPresenterComl coml;

    List<ChapterItemEntity.DataBean.DatasBean> datasBeanList;

    RecyclerView recycler;

    SmartRefreshLayout smartRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_item);
        Intent intent=getIntent();
        cid=intent.getIntExtra("cid",0);
        initView();
        initData();
    }

    void initView(){
        coml=new ChapterPresenterComl(this);

        recycler=findViewById(R.id.recycler);

        smartRefreshLayout=findViewById(R.id.refreshLayout);
        smartRefreshLayout.setEnableAutoLoadMore(true);//是否启用列表惯性滑动到底部时自动加载更多
        smartRefreshLayout.setEnableLoadMore(true);//是否启用加载更多功能
        smartRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 0;
                coml.getChapterDetail(cid,page);
                refreshLayout.finishRefresh(1000);//下拉刷新结束
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Log.e("xxx",page+"");
                page++;
                coml.getChapterDetail(cid,page);
                refreshLayout.finishLoadMore(1000);
            }
        });

        adapter=new ChapterItemAdapter(R.layout.list_item_chapter_detail,datasBeanList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recycler.setLayoutManager(linearLayoutManager);

        recycler.setAdapter(adapter);

    }

    void initData(){
        coml.getChapterDetail(cid,page);
    }


    @Override
    public void getChapterItemList(List<ChapterItemEntity.DataBean.DatasBean> beans) {
        if (!(beans.size() >0)){
            Toast.makeText(this,"没有更多数据了",Toast.LENGTH_SHORT).show();
            return;
        }
        if (page>0){
            for (ChapterItemEntity.DataBean.DatasBean data:beans){
                datasBeanList.add(data);
            }
        }else {
            datasBeanList=beans;
        }
        adapter.replaceData(datasBeanList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void goToWeb(String link) {
        Intent intent=new Intent(this, WebActivity.class);

        intent.putExtra("link",link);

        startActivity(intent);
    }
}