package com.rain.wan_andorid.fragment.nav;

import android.util.Log;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.rain.wan_andorid.R;
import com.rain.wan_andorid.adapter.ProjectAdapter;
import com.rain.wan_andorid.base.BaseFragment;
import com.rain.wan_andorid.entity.NaviEntity;
import com.rain.wan_andorid.fragment.nav.adapter.FragTabAdapter;
import com.rain.wan_andorid.fragment.nav.presenter.NaviPresenterComl;
import com.rain.wan_andorid.fragment.nav.view.INaviView;
import com.rain.wan_andorid.fragment.project.presenter.ProjectPresernterCompl;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.verticaltablayout.VerticalTabLayout;

public class NavFragment extends BaseFragment implements INaviView {

    NaviPresenterComl coml;

    List<String> names;


    VerticalTabLayout tabLayout;

    ViewPager viewPager;

    FragTabAdapter adapter;

    @Override
    protected int setContentView() {
        return R.layout.fragment_nav;
    }

    @Override
    protected void startLoad() {
        coml.getNaviList();
    }

    @Override
    protected void initData() {
        tabLayout=findViewById(R.id.vTab);

        viewPager=findViewById(R.id.view_pager);


        adapter=new FragTabAdapter(getChildFragmentManager());

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        coml=new NaviPresenterComl(this);
    }

    @Override
    public void getNaviList(List<NaviEntity.DataBean> beanList) {
        names=new ArrayList<>();
        if (beanList.size()>0){
            for (NaviEntity.DataBean bean:beanList){
                names.add(bean.getName());
            }
            adapter.setList(names,beanList);
        }

        Log.e("xxx",names.size()+names.toString());
    }
}
