package com.luohao.sportsmeet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.luohao.sportsmeet.R;

public class ActActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);

        webView = (WebView) findViewById(R.id.act);
//        webView.getSettings();
    }
}
