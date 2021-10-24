package com.rain.wan_andorid.fragment.chapter.adapter;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.rain.wan_andorid.R;
import com.rain.wan_andorid.entity.ChapterEntity;
import com.rain.wan_andorid.fragment.chapter.view.IChapterView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChapterAdapter extends BaseQuickAdapter<ChapterEntity.DataBean, BaseViewHolder> {

    IChapterView iChapterView;

    public ChapterAdapter(int layoutResId, @Nullable List<ChapterEntity.DataBean> data,IChapterView iChapterView) {
        super(layoutResId, data);
        this.iChapterView=iChapterView;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ChapterEntity.DataBean dataBean) {
        TextView txt_title=baseViewHolder.findView(R.id.txt_title);
        LinearLayout linearLayout=baseViewHolder.findView(R.id.layout_chapter);

        txt_title.setText(dataBean.getName());

        Log.e("xxx"," " + baseViewHolder.getAdapterPosition());
        int n=baseViewHolder.getAdapterPosition();


        if (n%6==0){
            linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.chapter_c1));
        }if (n%6==1){
            linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.chapter_c2));
        }if (n%6==2){
            linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.chapter_c3));
        }if (n%6==3){
            linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.chapter_c4 ));
        }if (n%6==4){
            linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.chapter_c5));
        }if (n%6==5){
            linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.chapter_c6));
        }



        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iChapterView.goToWeb(dataBean.getId());
            }
        });


    }

}
