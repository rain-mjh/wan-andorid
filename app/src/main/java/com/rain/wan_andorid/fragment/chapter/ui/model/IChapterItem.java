package com.rain.wan_andorid.fragment.chapter.ui.model;

import com.rain.wan_andorid.common.ACallback;

public interface IChapterItem {
    void getChapterItemList(int cid, int page, ACallback<String> aCallback);
}
