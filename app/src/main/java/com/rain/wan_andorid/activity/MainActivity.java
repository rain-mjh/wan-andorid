package com.rain.wan_andorid.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.rain.wan_andorid.R;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {


    NavigationView nav_about;

    DrawerLayout drawerMain;

    Toolbar toolbar;

    TextView tv_txt;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_project, R.id.navigation_tree,
                R.id.navigation_nav, R.id.navigation_chapter)
                .build();
        navView.setItemIconTintList(null);
        navView.setItemRippleColor(null);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        NavigationUI.setupWithNavController(navView, navController);

        //默认动画
        navView.setLabelVisibilityMode(0);
        //默认清除动画（显示文字）
        navView.setLabelVisibilityMode(1);

        initView();
    }

    private void initView() {

        tv_txt=findViewById(R.id.tv_txt);

        nav_about = findViewById(R.id.nav_about);
        nav_about.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                //收藏
                case R.id.nav_menu_collect:

                    break;
                //设置
                case R.id.nav_setting:

                    break;
                //关于
                case R.id.nav_menu_about:

                    break;
                //退出
                case R.id.nav_menu_logout:

                    break;
            }
            return true;
        });

        tv_txt.setText("版本"+getAppVersionName(this));
    }

    private void initToolbar() {
        drawerMain = findViewById(R.id.drawerMain);
        toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(MainActivity.this, drawerMain, toolbar, R.string.app_name, R.string.app_name);
        drawerMain.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();
    }


    public static String getAppVersionName(Context context) {

        String versionName = "";
        try {
            PackageManager pm = context.getPackageManager();

            PackageInfo p1 = pm.getPackageInfo(context.getPackageName(), 0);

            versionName = p1.versionName;
            if (TextUtils.isEmpty(versionName) || versionName.length() <= 0) {
                return "";
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;

    }

    private boolean mIsExit;
    /**双击返回键退出*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mIsExit) {
                this.finish();
            } else {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mIsExit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIsExit = false;
                    }
                }, 2000);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}