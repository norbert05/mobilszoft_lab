package com.example.mobsofthw.scenes.newsList

import androidx.lifecycle.Observer
import com.example.mobsofthw.R
import com.example.mobsofthw.models.util.NetworkHelper.checkNetworkConnection
import com.example.mobsofthw.scenes.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsListActivity : BaseActivity() {

    private val viewModel: NewsListViewModel by viewModel()

    override fun getContentView() = R.layout.activity_main

    override fun initUi() {
        fetchNews()
    }

    private fun fetchNews() {
        viewModel.uiData.observe(this, Observer { newsList ->
            val newsList = newsList
        })
        if (!checkNetworkConnection(this)) return
        viewModel.fetchNews()
    }
}
