package com.rain.wan_andorid.fragment.tree.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.rain.wan_andorid.R;
import com.rain.wan_andorid.adapter.ProjectAdapter;
import com.rain.wan_andorid.entity.TreeDetailEntity;
import com.rain.wan_andorid.entity.TreeEntity;
import com.rain.wan_andorid.fragment.project.presenter.ProjectPresernterCompl;
import com.rain.wan_andorid.fragment.tree.ui.adapter.TreeDetailAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.toLowerCase;

public class TreeDetailActivity extends AppCompatActivity {


    TabLayout tabLayout;

    ViewPager viewPager;

    TreeDetailAdapter adapter;

    private List<String> names;

    List<TreeEntity.DataBean.ChildrenBean> dataBeans;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_detail);
        dataBeans=new ArrayList<>();
        names=new ArrayList<>();
        Intent intent = getIntent();
        String link= intent.getStringExtra("link");
        Log.e("xxx",link);
        TreeEntity.DataBean.ChildrenBean[] datalist = new Gson().fromJson(link, TreeEntity.DataBean.ChildrenBean[].class);

        for (TreeEntity.DataBean.ChildrenBean bean:datalist){
            dataBeans.add(bean);

            names.add(toLowerCase(bean.getName()));
        }

        Log.e("xxx",names.toString());
        initData();
    }

    public void initData(){
        tabLayout=findViewById(R.id.tab_layout);

        viewPager=findViewById(R.id.view_pager);

        adapter=new TreeDetailAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        adapter.setList(names,dataBeans);
    }
}