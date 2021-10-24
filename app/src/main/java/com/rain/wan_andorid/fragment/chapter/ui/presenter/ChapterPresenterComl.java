package com.rain.wan_andorid.fragment.chapter.ui.presenter;

import com.google.gson.Gson;
import com.rain.wan_andorid.common.ACallback;
import com.rain.wan_andorid.entity.ChapterItemEntity;
import com.rain.wan_andorid.fragment.chapter.ui.model.ChapterItemModel;
import com.rain.wan_andorid.fragment.chapter.ui.model.IChapterItem;
import com.rain.wan_andorid.fragment.chapter.ui.view.IChapterItemView;

public class ChapterPresenterComl  implements IChapterPresenter{

    IChapterItemView itemView;
    IChapterItem iChapterItem;


    public ChapterPresenterComl( IChapterItemView itemView) {
        this.itemView=itemView;
        iChapterItem=new ChapterItemModel();
    }

    @Override
    public void getChapterDetail(int cid, int page) {
        iChapterItem.getChapterItemList(cid, page, new ACallback<String>() {
            @Override
            public void onSuccess(String data) {
                ChapterItemEntity entity=new Gson().fromJson(data,ChapterItemEntity.class);
                if (entity.getErrorCode()==0){
                    itemView.getChapterItemList(entity.getData().getDatas());
                }
            }

            @Override
            public void onFail(int errCode, String errMsg) {

            }
        });
    }
}
