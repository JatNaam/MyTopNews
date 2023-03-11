package com.example.mytopnews;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;


public class WebActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        //隐藏自带的菜单栏
//        ActionBar actionbar = getSupportActionBar();
//        if (actionbar != null) {
//            actionbar.hide();
//        }
        WebView webView = findViewById(R.id.webView);
        /* 解决页面空白问题 */
        WebSettings webSettings = webView.getSettings();
        //是否允许JavaScript脚本运行，默认为false。设置true时，会提醒可能造成XSS漏洞
        webSettings.setJavaScriptEnabled(true);
        //开启本地DOM存储
        webSettings.setDomStorageEnabled(true);
        //可以通过setAppCacheEnabled方法来控制webView是否有缓存：
        webSettings.setAppCacheEnabled(false);
        /*其它功能*/
        //是否可以缩放，默认true
        webSettings.setSupportZoom(true);
        //是否显示缩放按钮，默认false
        webSettings.setBuiltInZoomControls(true);
        //设置此属性，可任意比例缩放。大视图模式
        webSettings.setUseWideViewPort(true);
        //和setUseWideViewPort(true)一起解决网页自适应问题
        webSettings.setLoadWithOverviewMode(true);

        // 对网站的HTTP和HTTPS协议的处理
        webView.setWebViewClient(new WebViewClient() {
            /**
             * 使一切操作如登录操作，都在WebView中进行，不打开浏览器
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("http://") || url.startsWith("https://")) {
                    view.loadUrl(url);
                    return false;
                } else {//如果不是http开头的地址，就是走这里。
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        WebActivity.this.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                }
            }
        });
        // 从Intent中获取要访问的新闻网站URL
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        if (data != null)
            webView.loadUrl(data);
    }
}
