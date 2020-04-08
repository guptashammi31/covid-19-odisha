package com.technogenr.ocovid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebviewActivity extends AppCompatActivity {
    private WebView webView;
 //   String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    //  String  str = getIntent().getExtras().getString("weburl");

        webView = (WebView) findViewById(R.id.web);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("ff");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }


    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}