package com.rain.wan_andorid.adapter;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.rain.wan_andorid.R;
import com.rain.wan_andorid.entity.ArticleEntity;
import com.rain.wan_andorid.fragment.home.view.IHomeView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ArticleAdapter  extends BaseQuickAdapter<ArticleEntity.DataBean.DatasBean, BaseViewHolder> {
    IHomeView iHomeView;

    public ArticleAdapter(int layoutResId, @NotNull List<ArticleEntity.DataBean.DatasBean> data,IHomeView iHomeView) {
        super(layoutResId,data);
        this.iHomeView=iHomeView;
    }


    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ArticleEntity.DataBean.DatasBean datasBean) {

        Log.e("xxx",datasBean.toString());

        TextView tx_title=baseViewHolder.findView(R.id.tx_title);
        TextView tx_chapter=baseViewHolder.findView(R.id.tx_chapter);
        TextView tx_author=baseViewHolder.findView(R.id.tx_author);
        TextView tx_date=baseViewHolder.findView(R.id.tx_date);
        RelativeLayout web_layout=baseViewHolder.findView(R.id.web_layout);

        tx_title.setText(datasBean.getTitle());
        if (datasBean.getSuperChapterName().isEmpty() || datasBean.getAuthor().isEmpty()){
            tx_chapter.setVisibility(View.GONE);
            tx_author.setVisibility(View.GONE);
        }

        tx_chapter.setText(datasBean.getSuperChapterName());
        tx_author.setText(datasBean.getAuthor());
        tx_date.setText(datasBean.getNiceShareDate());

        web_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iHomeView.goToWeb(datasBean.getLink());
            }
        });
    }
}
