package com.rain.wan_andorid.activity.web;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.rain.wan_andorid.R;

public class WebActivity extends AppCompatActivity {
    String link;


    AgentWeb mAgentWeb;

    LinearLayout web_layout;

    TextView title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        setContentView(R.layout.activity_web);

        title=findViewById(R.id.tv_title);
        title.setText("玩安卓");

        Intent intent=getIntent();

        link=intent.getStringExtra("link");

        Log.e("XX",link);

        web_layout=findViewById(R.id.web_layout);

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent( web_layout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                //.ready()
                .go(link);
    }
}