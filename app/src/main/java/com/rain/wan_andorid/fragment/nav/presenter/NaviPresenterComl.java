package com.rain.wan_andorid.fragment.nav.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.rain.wan_andorid.common.ACallback;
import com.rain.wan_andorid.entity.NaviEntity;
import com.rain.wan_andorid.fragment.nav.model.INavi;
import com.rain.wan_andorid.fragment.nav.model.NAviModel;
import com.rain.wan_andorid.fragment.nav.view.INaviView;

public class NaviPresenterComl implements INaviPresenter {

    INavi iNavi;

    INaviView iNaviView;

    public NaviPresenterComl( INaviView iNaviView) {
        this.iNaviView= iNaviView;
        iNavi=new NAviModel();
    }

    @Override
    public void getNaviList() {
        iNavi.getNaviList(new ACallback<String>() {
            @Override
            public void onSuccess(String data) {
               // Log.e("xx",data);

                NaviEntity entity=new Gson().fromJson(data,NaviEntity.class);
                if (entity.getErrorCode()==0){
                    iNaviView.getNaviList(entity.getData());
                }
            }

            @Override
            public void onFail(int errCode, String errMsg) {

            }
        });
    }
}
