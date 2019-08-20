package com.example.fibonaci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class bio extends AppCompatActivity {
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        myWebView = findViewById(R.id.bio);

        myWebView.loadUrl("https://en.wikipedia.org/wiki/Fibonacci");
        myWebView.setWebViewClient(new WebViewClient());
    }
}
