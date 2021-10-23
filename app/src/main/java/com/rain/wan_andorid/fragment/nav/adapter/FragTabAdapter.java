package com.rain.wan_andorid.fragment.nav.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.gson.Gson;
import com.rain.wan_andorid.entity.NaviEntity;
import com.rain.wan_andorid.fragment.nav.ui.NavItemFragment;

import java.util.ArrayList;
import java.util.List;

public class FragTabAdapter extends FragmentPagerAdapter {

    private ArrayList<String> names;

    List<NaviEntity.DataBean> dataBeans;

    public FragTabAdapter(@NonNull FragmentManager fm) {
        super(fm);
        names=new ArrayList<>();
    }

    /**
     * 数据列表
     *
     * @param datas
     */
    public void setList(List<String> datas, List<NaviEntity.DataBean> dataBeans) {
        this.names.clear();
        this.names.addAll(datas);
        this.dataBeans=dataBeans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        NavItemFragment fragment = new NavItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", names.get(position));
        bundle.putInt("id",dataBeans.get(position).getCid());
        bundle.putString("data",new Gson().toJson(dataBeans.get(position)));
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
