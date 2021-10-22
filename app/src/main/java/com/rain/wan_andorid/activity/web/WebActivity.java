package com.rain.wan_andorid.activity.web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.rain.wan_andorid.R;

public class WebActivity extends AppCompatActivity {
    String link;


    AgentWeb mAgentWeb;

    LinearLayout web_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

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