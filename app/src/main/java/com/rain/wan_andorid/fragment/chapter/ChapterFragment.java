package com.rain.wan_andorid.fragment.chapter;

import android.content.Intent;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rain.wan_andorid.R;
import com.rain.wan_andorid.base.BaseFragment;
import com.rain.wan_andorid.entity.ChapterEntity;
import com.rain.wan_andorid.fragment.chapter.adapter.ChapterAdapter;
import com.rain.wan_andorid.fragment.chapter.presenter.ChapterPresenterComl;
import com.rain.wan_andorid.fragment.chapter.ui.ChapterItemActivity;
import com.rain.wan_andorid.fragment.chapter.view.IChapterView;
import com.rain.wan_andorid.utils.GridSpacingItemDecoration;

import java.util.List;

public class ChapterFragment  extends BaseFragment implements IChapterView {

    RecyclerView  recyclerView;

    ChapterAdapter adapter;

    ChapterPresenterComl coml;

    List<ChapterEntity.DataBean> dataBeanList;

    @Override
    protected int setContentView() {
        return R.layout.fragment_chapter;
    }

    @Override
    protected void startLoad() {
        coml.getChapterList();
    }

    @Override
    protected void initData() {
        recyclerView=findViewById(R.id.recycleview);


        coml=new ChapterPresenterComl(this);
        adapter=new ChapterAdapter(R.layout.list_item_chapter,dataBeanList,this);

        int spanCount = 2; // 3 columns
        int spacing = 0; // 50px
        boolean includeEdge = true;
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void getChapterList(List<ChapterEntity.DataBean> beanList) {
        if (beanList.size()>0){
            adapter.replaceData(beanList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void goToWeb(int link) {
        Intent intent=new Intent(getContext(), ChapterItemActivity.class);
        intent.putExtra("cid",link);
        startActivity(intent);
    }
}
