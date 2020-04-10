package com.technogenr.ocovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class TwitterWebActivity extends AppCompatActivity {
    private WebView webView;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_web);
        webView = (WebView) findViewById(R.id.admission);
        //progressbar = (ProgressBar) findViewById(R.id.progressbar);
        str = getIntent().getExtras().getString("link");


        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);

        webView.loadUrl(str);
        // progressbar.setVisibility(View.GONE);





    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    public void reload(View view){
        webView.reload();}
}
