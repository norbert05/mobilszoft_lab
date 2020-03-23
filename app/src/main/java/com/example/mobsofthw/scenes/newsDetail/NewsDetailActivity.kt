package com.example.mobsofthw.scenes.newsDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobsofthw.R

class NewsDetailActivity : AppCompatActivity() {

    lateinit var presenter: NewsDetailPresenterInput

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        initializeProperties()
    }

    private fun initializeProperties() {
        presenter = NewsDetailPresenter(this)
    }
}
