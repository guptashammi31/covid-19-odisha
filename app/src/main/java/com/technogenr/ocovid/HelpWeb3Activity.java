package com.technogenr.ocovid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class HelpWeb3Activity extends AppCompatActivity {
    private String pdflink;
    TextView edt;
    WebView webview;
    ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_web3);
        pdflink = getIntent().getStringExtra("pdflink");



        webview = (WebView)findViewById(R.id.webview);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setDisplayZoomControls(false);

        progressbar = (ProgressBar) findViewById(R.id.progressbar);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setPluginState(WebSettings.PluginState.ON);

        String filename ="http://www3.nd.edu/~cpoellab/teaching/cse40816/android_tutorial.pdf";
        webview.loadUrl("http://docs.google.com/gview?embedded=true&url=" +pdflink+".pdf");

        webview.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                progressbar.setVisibility(View.GONE);
            }
        });


    }

}