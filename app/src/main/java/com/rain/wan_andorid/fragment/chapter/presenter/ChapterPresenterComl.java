package com.rain.wan_andorid.fragment.chapter.presenter;

import com.google.gson.Gson;
import com.rain.wan_andorid.common.ACallback;
import com.rain.wan_andorid.entity.ChapterEntity;
import com.rain.wan_andorid.fragment.chapter.model.ChapterModel;
import com.rain.wan_andorid.fragment.chapter.model.IChapter;
import com.rain.wan_andorid.fragment.chapter.view.IChapterView;

public class ChapterPresenterComl implements IChapterPresenter {

    IChapterView iChapterView;

    IChapter iChapter;

    public ChapterPresenterComl(IChapterView iChapterView) {
        this.iChapterView=iChapterView;
        iChapter=new ChapterModel();
    }

    @Override
    public void getChapterList() {
        iChapter.getChapterList(new ACallback<String>() {
            @Override
            public void onSuccess(String data) {
                ChapterEntity entity=new Gson().fromJson(data,ChapterEntity.class);
                if (entity.getErrorCode()==0){
                    iChapterView.getChapterList(entity.getData());
                }
            }

            @Override
            public void onFail(int errCode, String errMsg) {

            }
        });
    }
}
