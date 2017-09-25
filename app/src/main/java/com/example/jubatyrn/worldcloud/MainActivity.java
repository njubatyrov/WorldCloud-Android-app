package com.example.jubatyrn.worldcloud;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private WebView webview;

    String[] wordCloud = new String[]{ "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb",
            "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Prepare webview: add zoom controls and start zoomed out

        webview = (WebView) findViewById(R.id.webview);
        final WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setBuiltInZoomControls(true);
//        webSettings.setSupportZoom(true);
//        webSettings.setUseWideViewPort(true);
//        webSettings.setAllowFileAccess(true);
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setAllowContentAccess(true);
//        webSettings.setAllowFileAccessFromFileURLs(true);
//        webSettings.setAllowUniversalAccessFromFileURLs(true);
//        webview.setWebViewClient(new WebViewClient());
//        webview.setWebChromeClient(new WebChromeClient());

        //webview.setInitialScale(1);


        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                StringBuffer sb = new StringBuffer();
                sb.append("wordCloud([");
                for (int i = 0; i < wordCloud.length; i++) {
                    sb.append("'").append(wordCloud[i]).append("'");
                    if (i < wordCloud.length - 1) {
                        sb.append(",");
                    }
                }
                sb.append("])");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    webview.evaluateJavascript(sb.toString(), null);
                } else {
                    webview.loadUrl("javascript:" + sb.toString());
                }

            }
        });

        // Load base html from the assets directory
        webview.loadUrl("file:///android_asset/d3.html");
    }
}


