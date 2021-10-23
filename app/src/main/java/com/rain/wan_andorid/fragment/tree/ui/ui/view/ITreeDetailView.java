package com.rain.wan_andorid.fragment.tree.ui.ui.view;

import com.rain.wan_andorid.entity.TreeDetailEntity;

import java.util.List;

public interface ITreeDetailView {
      void getTreeDetailList(List<TreeDetailEntity.DataBean.DatasBean> datasBeans);
      void goToWeb(String link);
}
