package com.itdepartment.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.itdepartment.R

class SocialMediaViewActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    private lateinit var url: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media_view)
        val bundle = intent.extras
        if (bundle != null) {
            url = bundle.getString("url") as String


            webView = findViewById(R.id.webView)

            // Enable JavaScript (if needed)
            webView.settings.javaScriptEnabled = true

            // Set a WebViewClient to handle navigation within the WebView
            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    val uri = request?.url
                    val scheme = uri?.scheme

                    return if (scheme == "http" || scheme == "https") {
                        false // Let WebView handle the URL
                    } else {
                        // Handle custom schemes
                        val intent = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intent)
                        true
                    }
                }
            }

            // Load URL
            webView.loadUrl(url)
        }


    }

}