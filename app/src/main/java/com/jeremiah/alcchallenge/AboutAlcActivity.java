package com.jeremiah.alcchallenge;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutAlcActivity extends AppCompatActivity {

    ProgressDialog progessDialog;
    WebView aboutAlcWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        aboutAlcWebview = findViewById(R.id.about_alc_webview);

        aboutAlcWebview.getSettings().setJavaScriptEnabled(true);
        aboutAlcWebview.setWebViewClient(new WebviewClientImpl());
        aboutAlcWebview.loadUrl("https://andela.com/alc/");


    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (aboutAlcWebview.canGoBack()) {
                        aboutAlcWebview.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }


    private class WebviewClientImpl extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            showProgressIndicator(true);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            showProgressIndicator(false);
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void showProgressIndicator(boolean active) {

        try {
            if (this.isFinishing()) {
                return;
            }

            if (progessDialog == null) {
                progessDialog = new ProgressDialog(this);
//                progessDialog.setCanceledOnTouchOutside(true);
                progessDialog.setMessage("Please wait...");
            }

            if (active && !progessDialog.isShowing()) {
                progessDialog.show();
            } else {
                progessDialog.dismiss();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
