package com.rain.wan_andorid.web;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.webview.QMUIWebView;
import com.qmuiteam.qmui.widget.webview.QMUIWebViewContainer;
import com.rain.wan_andorid.R;

public class MuiWebActivity extends AppCompatActivity {

    QMUITopBarLayout topbar;

    ProgressBar progressBar;

    QMUIWebViewContainer webviewcontainer;

    QDWebView mWebView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mui_web);
        initView();
        initTopbar();
        initWebView();
    }



    private void initView() {
        topbar=findViewById(R.id.topbar);
        progressBar=findViewById(R.id.progress_bar);
        webviewcontainer=findViewById(R.id.webviewcontainer);
    }

    //tabLayout
    private void initTopbar() {
        topbar.setTitle("webView").setTextColor(getResources().getColor(R.color.white));
        topbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public boolean needDispatchSafeAreaInset(){
        return false;
    }


    public void initWebView() {
        mWebView =new  QDWebView(this);

        boolean needDispatchSafeAreaInset= needDispatchSafeAreaInset();

        webviewcontainer.addWebView(mWebView,needDispatchSafeAreaInset);

        webviewcontainer.setCustomOnScrollChangeListener(new QMUIWebView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(WebView webView, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

            }
        });


        WebChromeClient webChromeClient = new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                progressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    //加载完毕隐藏进度条
                   progressBar.setVisibility(View.GONE);

                }
                super.onProgressChanged(view, newProgress);
            }
        };
        mWebView.setWebChromeClient(webChromeClient);
        mWebView.requestFocus(View.FOCUS_DOWN);
        //WebViewUtil.setZoomControlGone(mWebView);
        mWebView.loadUrl("https://www.baidu.com");

    }





    class onScrollWebContent{

        public onScrollWebContent(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
            this.scrollX = scrollX;
            this.scrollY = scrollY;
            this.oldScrollX = oldScrollX;
            this.oldScrollY = oldScrollY;
        }

        int scrollX;
        int scrollY;
        int oldScrollX;
        int oldScrollY;

    }

}