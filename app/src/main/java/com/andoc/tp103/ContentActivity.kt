package com.andoc.tp103

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_layout.*
import kotlinx.android.synthetic.main.content_layout.view.*


class ContentActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)

       val webView = tvUrl
        webView.webViewClient = WebViewClient()

        // this will load the url of the website
        webView.loadUrl(intent.getStringExtra("url"))

        // this will enable the javascript settings

        webView.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        webView.settings.setSupportZoom(true)


        webView.settings.saveFormData
    }

    // if you press Back button this code will work
    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (tvUrl.canGoBack())
            tvUrl.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }

}