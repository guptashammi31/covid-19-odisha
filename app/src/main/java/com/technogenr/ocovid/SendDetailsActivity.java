package com.technogenr.ocovid;

import android.app.ProgressDialog;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.util.Calendar;

public class SendDetailsActivity extends AppCompatActivity {
    TextView docsetname,docsetexp,davll,dprices;
    ImageView image;

    int day,month,year,hour,min;
    EditText editdate;

    String dmy,ymd,mh,davl,dprice;
    Calendar c;
    // Folder path for Firebase Storage.
    String Storage_Path = "All_Nurse/";



    // Creating EditText.
    EditText ImageName,name,number,date,discription,address ;

    // Creating ImageView.

    // Creating URI.
    Uri FilePathUri;

    // Creating StorageReference and DatabaseReference object.
    StorageReference storageReference;
     private DatabaseReference databaseReference;
    DatabaseReference ref;
WebView webView;
    // Image request code for onActivityResult() .
    int Image_Request_Code = 7;

    ProgressDialog progressDialog ;

    //    ListView listOfMessages;
    String str,n,w;
    String urlimage;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_details);


       // progressbar = (ProgressBar) findViewById(R.id.progressbar);

        str = getIntent().getExtras().getString("link");



         webView = (WebView) findViewById(R.id.web);
                 webView.setWebViewClient(new WebViewClient());



                 WebSettings webSettings = webView.getSettings();
                 webSettings.setJavaScriptEnabled(true);
        webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setDomStorageEnabled(true);
                 webView.loadUrl(str);
                 webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                //progressbar.setVisibility(View.GONE);
            }
        });
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