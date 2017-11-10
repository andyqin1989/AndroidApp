package com.andyqin.app;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.andyqin.app.model.User;
import com.andyqin.framework.network.OnServiceListener;
import com.andyqin.framework.network.volley.ServiceManagerImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button1;

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //webView.loadUrl("http://wx.bocweb.cn/daoshun/whf/");
                webView.loadUrl("http://123.57.242.138:8080/userserver/safd.htm");
            }
        });
        webView = (WebView) findViewById(R.id.web_view);
        initWebView();
    }

    private void initWebView() {
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

    }

    private void getUserList() {
    }
}
