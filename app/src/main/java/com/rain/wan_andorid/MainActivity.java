package com.rain.wan_andorid;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {


    NavigationView nav_about;

    DrawerLayout drawerMain;

    Toolbar toolbar;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolbar();

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_project,R.id.navigation_tree,
                R.id.navigation_nav,R.id.navigation_chapter)
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

        nav_about=findViewById(R.id.nav_about);
        nav_about.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.nav_menu_collect:
                    Toasty.normal(MainActivity.this, item.getTitle()+"1").show();
                    break;

                case R.id.nav_about:
                    Toasty.normal(MainActivity.this, item.getTitle()+"2").show();
                    break;

                case R.id.nav_menu_logout:
                    Toasty.normal(MainActivity.this, item.getTitle()+"3").show();
                    break;
            }
            return true;
        });
    }

    private void initToolbar() {
        drawerMain=findViewById(R.id.drawerMain);
        toolbar=findViewById(R.id.toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(MainActivity.this, drawerMain, toolbar, R.string.app_name, R.string.app_name);
        drawerMain.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();
    }

}