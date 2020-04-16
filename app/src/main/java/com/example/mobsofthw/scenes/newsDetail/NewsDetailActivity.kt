package com.example.mobsofthw.scenes.newsDetail

import com.example.mobsofthw.R
import com.example.mobsofthw.scenes.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsDetailActivity : BaseActivity() {

    private val viewModel: NewsDetailViewModel by viewModel()

    override fun getContentView() = R.layout.activity_news_detail

    override fun initUi() {
    }
}

