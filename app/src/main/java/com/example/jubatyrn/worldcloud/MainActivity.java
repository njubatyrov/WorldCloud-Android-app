package com.example.jubatyrn.worldcloud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Prepare webview: add zoom controls and start zoomed out

        webview = (WebView) findViewById(R.id.webview);
        final WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);

        webview.setWebChromeClient(new WebChromeClient());
        webview.setInitialScale(1);

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // after the HTML page loads, run JS to initialize graph
                int dataset[] = new int[] {5,10,15,20,35};
                String text = Arrays.toString(dataset);

                webview.loadUrl("javascript:initGraph(" +
                        text + ", " + (webview.getHeight()) + ", " + (webview.getWidth()) + ")");
            }
        });

        // Load base html from the assets directory
        webview.loadUrl("file:///android_asset/html/graph.html");
    }
}


