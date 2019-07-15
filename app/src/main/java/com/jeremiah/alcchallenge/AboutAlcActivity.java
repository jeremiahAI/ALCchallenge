package com.jeremiah.alcchallenge;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutAlcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        WebView aboutAlcWebview = findViewById(R.id.about_alc_webview);

        aboutAlcWebview.getSettings().setJavaScriptEnabled(true);
        aboutAlcWebview.setWebViewClient(new WebviewClientImpl());
        aboutAlcWebview.loadUrl("https://andela.com/alc/");

    }

    private class WebviewClientImpl extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }
    }
}
