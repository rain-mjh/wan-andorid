package com.rain.wan_andorid.fragment.chapter.view;

import com.rain.wan_andorid.entity.ChapterEntity;

import java.util.List;

public interface IChapterView {
    void getChapterList(List<ChapterEntity.DataBean> beanList);

    void goToWeb(int link);
}
