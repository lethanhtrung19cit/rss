package com.google.firebase.referencecode.retrofitrss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity2 extends AppCompatActivity {
       WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=(WebView)findViewById(R.id.webview);
        Intent intent=getIntent();
        String link = intent.getStringExtra("linkNews");
        webView.loadUrl(link);
    }
}