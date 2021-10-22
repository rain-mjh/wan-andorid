package com.rain.wan_andorid.fragment.project.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rain.wan_andorid.R;
import com.rain.wan_andorid.activity.web.WebActivity;
import com.rain.wan_andorid.adapter.ProjectItemAdapter;
import com.rain.wan_andorid.base.BaseFragment;
import com.rain.wan_andorid.entity.ProjectItemEntity;
import com.rain.wan_andorid.fragment.project.ui.presenter.ProjectItemPresernterCompl;
import com.rain.wan_andorid.fragment.project.ui.view.ProjectItemView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.List;


public class ProjectItemFragment extends BaseFragment  implements ProjectItemView {
    int chat_id;

    RecyclerView recycler;

    int page=1;

    SmartRefreshLayout smartRefreshLayout;

    String name;

    ProjectItemPresernterCompl compl;

    ProjectItemAdapter adapter;

    List<ProjectItemEntity.DataBean.DatasBean> datasBeanList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("XX","进入fragment");

        Bundle bundle = getArguments();
        name = bundle.getString("name");
        chat_id=bundle.getInt("id");
        if (name == null) {
            name = "参数非法";
        }

    }


    @Override
    protected int setContentView() {
        return R.layout.fragment_project_item;
    }

    @Override
    protected void startLoad() {
        compl.getProjectList(page,chat_id);
    }

    @Override
    protected void initData() {
        recycler=findViewById(R.id.recycler);

        smartRefreshLayout=findViewById(R.id.refreshLayout);

        adapter=new ProjectItemAdapter(R.layout.list_item_project,datasBeanList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recycler.setLayoutManager(linearLayoutManager);

        recycler.setAdapter(adapter);

        smartRefreshLayout.setEnableAutoLoadMore(true);//是否启用列表惯性滑动到底部时自动加载更多
        smartRefreshLayout.setEnableLoadMore(true);//是否启用加载更多功能
        smartRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                compl.getProjectList(page,chat_id);
                refreshLayout.finishRefresh(1000);//下拉刷新结束
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Log.e("xxx",page+"");
                page++;
                compl.getProjectList(page,chat_id);
                refreshLayout.finishLoadMore(1000);
            }
        });
        compl=new ProjectItemPresernterCompl(this);
    }

    @Override
    public void getProjectItemList(List<ProjectItemEntity.DataBean.DatasBean> datasBean) {
        if (!(datasBean.size() >0)){
            Toast.makeText(getContext(),"没有更多数据了",Toast.LENGTH_SHORT).show();
            return;
        }
        if (page>1){
            for (ProjectItemEntity.DataBean.DatasBean data:datasBean){
                datasBeanList.add(data);
            }
        }else {
            datasBeanList=datasBean;
        }
        adapter.replaceData(datasBeanList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void goToWeb(String link) {

        Intent intent=new Intent(getContext(), WebActivity.class);

        intent.putExtra("link",link);

        startActivity(intent);
    }
}
