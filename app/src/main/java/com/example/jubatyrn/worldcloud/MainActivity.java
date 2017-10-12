package com.example.jubatyrn.worldcloud;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private WebView webview;

    String[] wordCloud = new String[]{ "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb",
            "Ice Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow"};
    Integer[] weights = new Integer[] {10, 20, 8, 7, 12, 20, 15, 5, 10, 10};

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Prepare webview: add zoom controls and start zoomed out

        button = (Button)findViewById(R.id.button2);

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

//        webview.setInitialScale(1);

        System.out.print("HODOODOD");
        final StringBuffer sb = new StringBuffer();
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                sb.append("wordCloud([");
                for (int i = 0; i < wordCloud.length; i++) {
                    sb.append("'").append(wordCloud[i]).append("'");
                    if (i < wordCloud.length - 1) {
                        sb.append(",");
                    }
                }
                sb.append("], [");
                for (int i = 0; i < weights.length; i++) {
                    sb.append(weights[i]);
                    if (i < weights.length - 1) {
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("LOPLOP");
                webview.loadUrl("javascript:" + sb.toString());
            }
        });
        System.out.print("HODOODOD");
    }
}


