package com.example.khabarzone

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext

class myWebView : AppCompatActivity() {

    lateinit var wb: WebView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    lateinit var pd: ProgressDialog



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_web_view)

        toolbar = findViewById(R.id.toolbar)
        wb = findViewById(R.id.wb)
        setSupportActionBar(toolbar)
        pd = ProgressDialog(this)

        pd.max = 100;
        pd.setMessage("Please Wait.....")
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        pd.show();
        val cIntent: Intent = intent
        val url: String? = cIntent.getStringExtra("url")


        pd.dismiss()
        wb.webViewClient = WebViewClient()
        wb.loadUrl(url!!)

    }
}