package com.example.ejercicio_semana5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web extends AppCompatActivity {
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        myWebView=findViewById(R.id.webview);

        myWebView.loadUrl("https://www.javeriana.edu.co/home");
        myWebView.setWebViewClient(new WebViewClient());

    }
}
