package com.technogenr.ocovid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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

        webView.loadUrl(str);
        // progressbar.setVisibility(View.GONE);

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
