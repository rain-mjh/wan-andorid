package com.rain.wan_andorid.fragment.tree.ui.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.rain.wan_andorid.R;
import com.rain.wan_andorid.entity.TreeDetailEntity;
import com.rain.wan_andorid.fragment.tree.ui.ui.view.ITreeDetailView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TreeDetailItemAdapter extends BaseQuickAdapter<TreeDetailEntity.DataBean.DatasBean, BaseViewHolder> {

    ITreeDetailView detailView;

    public TreeDetailItemAdapter(int layoutResId, @Nullable List<TreeDetailEntity.DataBean.DatasBean> data, ITreeDetailView detailView) {
        super(layoutResId, data);
        this.detailView=detailView;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, TreeDetailEntity.DataBean.DatasBean datasBean) {
        TextView txt_title=baseViewHolder.findView(R.id.txt_title);
        TextView txt_date=baseViewHolder.findView(R.id.txt_date);
        RelativeLayout layout_tee_detail=baseViewHolder.findView(R.id.layout_tee_detail);

        if (datasBean.getTitle().length()>30){
            txt_title.setText(datasBean.getTitle().substring(0,30)+"...");
        }else {
            txt_title.setText(datasBean.getTitle());
        }
        txt_date.setText(datasBean.getNiceDate());
        layout_tee_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailView.goToWeb(datasBean.getLink());
            }
        });
    }
}
