package com.rain.wan_andorid.fragment.project.ui.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.rain.wan_andorid.common.ACallback;
import com.rain.wan_andorid.entity.ProjectItemEntity;
import com.rain.wan_andorid.fragment.project.ui.model.IProjectItem;
import com.rain.wan_andorid.fragment.project.ui.model.ProjectItemModel;
import com.rain.wan_andorid.fragment.project.ui.view.ProjectItemView;

public class ProjectItemPresernterCompl implements IProjectItemPresenter {

    IProjectItem iProjectItem;

    ProjectItemView projectItemView;


    public ProjectItemPresernterCompl(ProjectItemView projectItemView) {
        iProjectItem=new ProjectItemModel();
        this.projectItemView=projectItemView;
    }


    @Override
    public void getProjectList(int page, int cid) {
        iProjectItem.getProjectList(page, cid, new ACallback<String>() {
            @Override
            public void onSuccess(String data) {
                Log.e("xxx",data);
                ProjectItemEntity entity=new Gson().fromJson(data,ProjectItemEntity.class);
                if (entity.getErrorCode()==0){
                    projectItemView.getProjectItemList(entity.getData().getDatas());
                }
            }

            @Override
            public void onFail(int errCode, String errMsg) {

            }
        });
    }
}
