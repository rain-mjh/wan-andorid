package com.rain.wan_andorid.fragment.tree.ui.ui.presenter;

import com.google.gson.Gson;
import com.rain.wan_andorid.common.ACallback;
import com.rain.wan_andorid.entity.TreeDetailEntity;
import com.rain.wan_andorid.fragment.tree.ui.ui.model.ITreeDetail;
import com.rain.wan_andorid.fragment.tree.ui.ui.model.TreeDetailModel;
import com.rain.wan_andorid.fragment.tree.ui.ui.view.ITreeDetailView;

public class TreeDetailPresenterComl implements ITreeDetailPresenter {

    ITreeDetail treeDetail;

    ITreeDetailView treeDetailView;


    public TreeDetailPresenterComl(ITreeDetailView treeDetailView) {
        treeDetail=new TreeDetailModel();
        this.treeDetailView=treeDetailView;
    }

    @Override
    public void getTreeDetail(int page, int cid) {
        treeDetail.getTreeDetailList(page, cid, new ACallback<String>() {
            @Override
            public void onSuccess(String data) {
                TreeDetailEntity entity=new Gson().fromJson(data,TreeDetailEntity.class);
                if (entity.getErrorCode()==0){
                    treeDetailView.getTreeDetailList(entity.getData().getDatas());
                }else {

                }
            }

            @Override
            public void onFail(int errCode, String errMsg) {

            }
        });
    }
}
