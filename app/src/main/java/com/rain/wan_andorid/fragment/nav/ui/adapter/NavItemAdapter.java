package com.rain.wan_andorid.fragment.nav.ui.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.rain.wan_andorid.R;
import com.rain.wan_andorid.entity.NaviEntity;
import com.rain.wan_andorid.fragment.nav.ui.view.INaviItemView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NavItemAdapter extends BaseQuickAdapter<NaviEntity.DataBean.ArticlesBean, BaseViewHolder> {
    INaviItemView iNaviItemView;

    List<NaviEntity.DataBean.ArticlesBean> beanList;

    public NavItemAdapter(int layoutResId, @Nullable List<NaviEntity.DataBean.ArticlesBean> data, INaviItemView iNaviItemView) {
        super(layoutResId, data);
        this.iNaviItemView = iNaviItemView;
        beanList=data;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, NaviEntity.DataBean.ArticlesBean articlesBean) {
        TextView txt_nav=baseViewHolder.findView(R.id.txt_nav);
        txt_nav.setText(articlesBean.getTitle());

        LinearLayout layout_navi=baseViewHolder.findView(R.id.layout_navi);
        layout_navi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iNaviItemView.goToWeb(articlesBean.getLink());
            }
        });
    }
}
