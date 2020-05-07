package com.example.mobsofthw.scenes.newsDetail

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.mobsofthw.R
import com.example.mobsofthw.scenes.base.BaseActivity
import kotlinx.android.synthetic.main.activity_news_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsDetailActivity : BaseActivity() {

    private val viewModel: NewsDetailViewModel by viewModel()
    private var url: String? = null
    override fun getContentView() = R.layout.activity_news_detail

    @RequiresApi(Build.VERSION_CODES.O)
    override fun initUi() {
        configureWebView()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun configureWebView() {
        val intent: Intent = intent
        url = intent.getStringExtra("url")
        title = intent.getStringExtra("title")

        webView.loadUrl(url)

        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                title = "Loading..."
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                title = intent.getStringExtra("title")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_fav -> {
            val intent: Intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(url))
            startActivity(intent)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

}
