package com.rain.wan_andorid.fragment.chapter.ui.view;

import com.rain.wan_andorid.entity.ChapterItemEntity;

import java.util.List;

public interface IChapterItemView {

    void getChapterItemList(List<ChapterItemEntity.DataBean.DatasBean> beans);

    void goToWeb(String link);

}
