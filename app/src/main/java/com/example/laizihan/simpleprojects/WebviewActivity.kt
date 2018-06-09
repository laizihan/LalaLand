package com.example.laizihan.simpleprojects

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_webview.*

class WebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        mWebview.settings.javaScriptEnabled = true;
        mWebview.loadUrl("https://www.baidu.com")
    }
}
