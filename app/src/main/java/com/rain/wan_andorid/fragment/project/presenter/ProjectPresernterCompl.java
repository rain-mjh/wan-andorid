package com.rain.wan_andorid.fragment.project.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.rain.wan_andorid.common.ACallback;
import com.rain.wan_andorid.entity.ProjectEntity;
import com.rain.wan_andorid.fragment.project.model.IProject;
import com.rain.wan_andorid.fragment.project.model.ProjectModel;
import com.rain.wan_andorid.fragment.project.view.IProjectView;

public class ProjectPresernterCompl implements IProjectPresenter {

    IProject iProject;

    IProjectView iProjectView;

    public ProjectPresernterCompl(IProjectView iProjectView) {
        this.iProjectView=iProjectView;
        iProject=new ProjectModel();
    }

    @Override
    public void getProject() {
        iProject.getProject(new ACallback<String>() {
            @Override
            public void onSuccess(String data) {
                //Log.e("xxx",data);
                ProjectEntity entity=new Gson().fromJson(data,ProjectEntity.class);
                if (entity.getErrorCode()==0){
                    iProjectView.getProject(entity.getData());
                }

            }

            @Override
            public void onFail(int errCode, String errMsg) {

            }
        });
    }
}
