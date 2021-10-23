package com.rain.wan_andorid.fragment.project;

import android.util.Log;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.rain.wan_andorid.R;
import com.rain.wan_andorid.adapter.ProjectAdapter;
import com.rain.wan_andorid.base.BaseFragment;
import com.rain.wan_andorid.entity.ProjectEntity;
import com.rain.wan_andorid.fragment.project.presenter.ProjectPresernterCompl;
import com.rain.wan_andorid.fragment.project.view.IProjectView;

import java.util.ArrayList;
import java.util.List;

public class ProjectFragment extends BaseFragment implements IProjectView {

    private List<String> names;

    TabLayout tabLayout;

    ViewPager viewPager;

    ProjectPresernterCompl presernterCompl;

    ProjectAdapter adapter;


    @Override
    protected int setContentView() {
        return R.layout.fragment_project;
    }

    @Override
    protected void startLoad() {
        presernterCompl.getProject();
    }

    @Override
    protected void initData() {
        tabLayout=findViewById(R.id.tab_layout);

        viewPager=findViewById(R.id.view_pager);

        presernterCompl=new ProjectPresernterCompl(this);

        adapter=new ProjectAdapter(getChildFragmentManager());

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void getProject(List<ProjectEntity.DataBean> dataBeans) {
        Log.e("xx",dataBeans.toString()+""+dataBeans.size());
        if (dataBeans.size()>0){
            names = new ArrayList<>();
            for (ProjectEntity.DataBean wanBean:dataBeans){
                names.add(wanBean.getName());
            }
            adapter.setList(names,dataBeans);
        }
    }
}
