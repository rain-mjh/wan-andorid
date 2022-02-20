package com.rain.wan_andorid.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rain.wan_andorid.R;

public class TitleLayout  extends RelativeLayout {
    TextView back;

    public TitleLayout(Context context, AttributeSet attributeSet) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.title_layout, this);
        back=inflate.findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });

    }
}
