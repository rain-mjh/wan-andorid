package com.rain.wan_andorid.fragment.tree;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rain.wan_andorid.R;
import com.rain.wan_andorid.adapter.ProjectItemAdapter;
import com.rain.wan_andorid.adapter.TreeAdapter;
import com.rain.wan_andorid.base.BaseFragment;
import com.rain.wan_andorid.entity.TreeEntity;
import com.rain.wan_andorid.fragment.tree.presenter.TreePresenter;
import com.rain.wan_andorid.fragment.tree.ui.TreeDetailActivity;
import com.rain.wan_andorid.fragment.tree.view.TreeView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.List;

public class TreeFragment  extends BaseFragment implements TreeView {

    TreeAdapter adapter;

    TreePresenter treePresenter;

    RecyclerView recycler;

    List<TreeEntity.DataBean> datasBeanList;

    @Override
    protected int setContentView() {
        return R.layout.fragment_tree;
    }

    @Override
    protected void startLoad() {
        treePresenter.getTreeList();
    }

    @Override
    protected void initData() {
        recycler=findViewById(R.id.recycleview);


        treePresenter=new TreePresenter(this);


        adapter=new TreeAdapter(R.layout.list_item_tree,datasBeanList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recycler.setLayoutManager(linearLayoutManager);

        recycler.setAdapter(adapter);

    }

    @Override
    public void getTreeList(List<TreeEntity.DataBean> beanList) {
       if(beanList.size()>0){
           adapter.replaceData(beanList);
           adapter.notifyDataSetChanged();
       }
    }

    @Override
    public void goToTreeDetail(String link) {
        Intent intent=new Intent(getContext(), TreeDetailActivity.class);
        intent.putExtra("link",link);
        startActivity(intent);
    }
}
