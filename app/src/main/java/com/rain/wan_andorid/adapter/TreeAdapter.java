package com.rain.wan_andorid.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.gson.Gson;
import com.rain.wan_andorid.R;
import com.rain.wan_andorid.entity.TreeEntity;
import com.rain.wan_andorid.fragment.tree.view.TreeView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TreeAdapter extends BaseQuickAdapter<TreeEntity.DataBean, BaseViewHolder> {

    TreeView treeView;


    public TreeAdapter(int layoutResId, @Nullable List<TreeEntity.DataBean> data,TreeView treeView) {
        super(layoutResId, data);
        this.treeView=treeView;
    }


    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, TreeEntity.DataBean dataBean) {
        RelativeLayout layout_tree=baseViewHolder.findView(R.id.layout_tree);

        TextView tv_title=baseViewHolder.findView(R.id.tv_title);
        TextView tv_content=baseViewHolder.findView(R.id.tv_content);

        List<TreeEntity.DataBean.ChildrenBean> childrenBean=dataBean.getChildren();

        StringBuilder builder=new StringBuilder();

        for (TreeEntity.DataBean.ChildrenBean bean:childrenBean){
            builder.append(bean.getName()+"  ");
        }

        tv_title.setText(dataBean.getName());
        tv_content.setText(builder.toString());

        layout_tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link=new Gson().toJson(childrenBean);
                treeView.goToTreeDetail(link);
            }
        });
    }
}
