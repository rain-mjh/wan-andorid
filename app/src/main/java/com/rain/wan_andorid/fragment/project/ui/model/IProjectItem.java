package com.rain.wan_andorid.fragment.project.ui.model;

import com.rain.wan_andorid.common.ACallback;

public interface IProjectItem {
    void getProjectList(int page,int cid,ACallback<String> callback);
}
