package com.example.newsapi

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapi.databinding.ActivityWebviewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWebviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView: WebView = binding.webView

        val url = intent.getStringExtra("url")

        if (!url.isNullOrEmpty()) {
            webView.loadUrl(url)
        }



    }

}