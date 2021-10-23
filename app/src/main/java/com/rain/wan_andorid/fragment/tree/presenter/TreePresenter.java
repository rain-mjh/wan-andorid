package com.rain.wan_andorid.fragment.tree.presenter;

import com.google.gson.Gson;
import com.rain.wan_andorid.common.ACallback;
import com.rain.wan_andorid.entity.TreeEntity;
import com.rain.wan_andorid.fragment.tree.model.ITree;
import com.rain.wan_andorid.fragment.tree.model.TreeModel;
import com.rain.wan_andorid.fragment.tree.view.TreeView;

public class TreePresenter implements ITreePresenter {
    ITree iTree;

    TreeView treeView;

    public TreePresenter(TreeView treeView) {
        this.treeView=treeView;
        iTree=new TreeModel();
    }

    @Override
    public void getTreeList() {
        iTree.getTreeList(new ACallback<String>() {
            @Override
            public void onSuccess(String data) {
               TreeEntity treeEntity=new Gson().fromJson(data,TreeEntity.class);
               if (treeEntity.getErrorCode()==0){
                   treeView.getTreeList(treeEntity.getData());
               }
            }

            @Override
            public void onFail(int errCode, String errMsg) {

            }
        });
    }


}
