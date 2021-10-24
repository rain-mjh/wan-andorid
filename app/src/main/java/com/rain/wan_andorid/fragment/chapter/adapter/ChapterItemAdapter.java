package com.rain.wan_andorid.fragment.chapter.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.rain.wan_andorid.R;
import com.rain.wan_andorid.entity.ChapterItemEntity;
import com.rain.wan_andorid.fragment.chapter.ui.view.IChapterItemView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChapterItemAdapter extends BaseQuickAdapter<ChapterItemEntity.DataBean.DatasBean, BaseViewHolder> {

    IChapterItemView iChapterItemView;

    public ChapterItemAdapter(int layoutResId, @Nullable List<ChapterItemEntity.DataBean.DatasBean> data,IChapterItemView iChapterItemView) {
        super(layoutResId, data);
        this.iChapterItemView=iChapterItemView;

    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ChapterItemEntity.DataBean.DatasBean datasBean) {
        TextView txt_title=baseViewHolder.findView(R.id.txt_title);
        TextView txt_date=baseViewHolder.findView(R.id.txt_date);
        RelativeLayout layout_tee_detail=baseViewHolder.findView(R.id.layout_tee_detail);

        txt_title.setText(datasBean.getTitle());

        txt_date.setText(datasBean.getNiceDate());

        layout_tee_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iChapterItemView.goToWeb(datasBean.getLink());
            }
        });
    }
}
