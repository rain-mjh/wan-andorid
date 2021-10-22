package com.rain.wan_andorid.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.rain.wan_andorid.R;
import com.rain.wan_andorid.base.MyApp;
import com.rain.wan_andorid.entity.ProjectItemEntity;
import com.rain.wan_andorid.fragment.project.ui.view.ProjectItemView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProjectItemAdapter extends BaseQuickAdapter<ProjectItemEntity.DataBean.DatasBean , BaseViewHolder> {

    ProjectItemView itemView;
    public ProjectItemAdapter(int layoutResId,  @NotNull List<ProjectItemEntity.DataBean.DatasBean> data, ProjectItemView itemView) {
        super(layoutResId,data);
        this.itemView=itemView;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, ProjectItemEntity.DataBean.DatasBean datasBean) {

        RelativeLayout layout=baseViewHolder.findView(R.id.layout_item);
        ImageView pro_img=baseViewHolder.findView(R.id.pro_img);
        TextView txt_title=baseViewHolder.findView(R.id.txt_title);
        TextView txt_content=baseViewHolder.findView(R.id.txt_content);
        TextView txt_type=baseViewHolder.findView(R.id.txt_type);
        TextView txt_date=baseViewHolder.findView(R.id.txt_date);

        Glide.with(MyApp.getInstance())
                .load(datasBean.getEnvelopePic())
                .into(pro_img);

        txt_title.setText(datasBean.getTitle());

        if (datasBean.getDesc().length()>25){
            txt_content.setText(datasBean.getDesc().substring(0,25)+"...");
        }else {
            txt_content.setText(datasBean.getDesc());
        }
        txt_type.setText(datasBean.getAuthor());
        txt_date.setText(datasBean.getNiceDate());

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemView.goToWeb(datasBean.getLink());
            }
        });
    }
}
