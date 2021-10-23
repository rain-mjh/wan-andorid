package com.rain.wan_andorid.fragment.tree.ui.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.rain.wan_andorid.entity.ProjectEntity;
import com.rain.wan_andorid.entity.TreeDetailEntity;
import com.rain.wan_andorid.entity.TreeEntity;
import com.rain.wan_andorid.fragment.project.ui.ProjectItemFragment;
import com.rain.wan_andorid.fragment.tree.ui.ui.TreeDetailItemFragment;

import java.util.ArrayList;
import java.util.List;


public class TreeDetailAdapter extends FragmentPagerAdapter {

    List<TreeEntity.DataBean.ChildrenBean> dataBeans;

    private List<String> names;

    public TreeDetailAdapter(@NonNull  FragmentManager fm) {
        super(fm);
        names=new ArrayList<>();
    }
    /**
     * 数据列表
     *
     * @param datas
     */
    public void setList(List<String> datas,List<TreeEntity.DataBean.ChildrenBean> dataBeans) {
        this.names.clear();
        this.names.addAll(datas);
        this.dataBeans=dataBeans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        TreeDetailItemFragment fragment = new TreeDetailItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", names.get(position));
        bundle.putInt("id",dataBeans.get(position).getId());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        if (dataBeans!=null){
            return dataBeans.size();
        }
        return 0;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String plateName = names.get(position);
        if (plateName == null) {
            plateName = "";
        } else if (plateName.length() > 15) {
            plateName = plateName.substring(0, 15) + "...";
        }
        return plateName;
    }
}
