package com.rain.wan_andorid.fragment.nav.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.rain.wan_andorid.R;
import com.rain.wan_andorid.activity.web.WebActivity;
import com.rain.wan_andorid.adapter.ProjectItemAdapter;
import com.rain.wan_andorid.base.BaseFragment;
import com.rain.wan_andorid.entity.NaviEntity;
import com.rain.wan_andorid.fragment.nav.ui.adapter.NavItemAdapter;
import com.rain.wan_andorid.fragment.nav.ui.view.INaviItemView;
import com.rain.wan_andorid.fragment.nav.view.INaviView;
import com.rain.wan_andorid.utils.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class NavItemFragment  extends BaseFragment implements INaviItemView {

    String name;
    int chat_id;

    NaviEntity.DataBean bean;

    TextView txt_nav;

    List<String> names;

    String  data;

    RecyclerView recyclerView;

    NavItemAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("XX","进入fragment");

        Bundle bundle = getArguments();
        name = bundle.getString("name");
        chat_id=bundle.getInt("id");
        data=bundle.getString("data");

        Log.e("xx",data);
        bean=new Gson().fromJson(data,NaviEntity.DataBean.class);
        if (name == null) {
            name = "参数非法";
        }

    }
    @Override
    protected int setContentView() {
        return R.layout.fragment_nav_item;
    }

    @Override
    protected void startLoad() {

        List<NaviEntity.DataBean.ArticlesBean> beanList=bean.getArticles();

        adapter=new NavItemAdapter(R.layout.list_item_navi,beanList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        int spanCount = 2; // 3 columns
        int spacing = 20; // 50px
        boolean includeEdge = true;

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        recyclerView =findViewById(R.id.recycler);
    }


    @Override
    public void goToWeb(String link) {
        Intent intent=new Intent(getContext(), WebActivity.class);
        intent.putExtra("link",link);
        startActivity(intent);
    }
}
