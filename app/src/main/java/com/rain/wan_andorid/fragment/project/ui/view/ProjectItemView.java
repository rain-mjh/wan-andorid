package com.rain.wan_andorid.fragment.project.ui.view;

import com.rain.wan_andorid.entity.ProjectItemEntity;

import java.util.List;

public interface ProjectItemView {
    void getProjectItemList(List<ProjectItemEntity.DataBean.DatasBean> datasBean);
    void goToWeb(String link);
}
