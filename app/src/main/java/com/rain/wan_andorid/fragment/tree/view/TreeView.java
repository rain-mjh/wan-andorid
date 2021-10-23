package com.rain.wan_andorid.fragment.tree.view;

import com.rain.wan_andorid.entity.TreeEntity;

import java.util.List;

public interface TreeView {
    void getTreeList(List<TreeEntity.DataBean> beanList);
    void goToTreeDetail(String link);
}
