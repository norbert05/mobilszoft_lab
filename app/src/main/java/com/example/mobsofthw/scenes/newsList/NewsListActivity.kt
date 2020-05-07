package com.example.mobsofthw.scenes.newsList

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobsofthw.R
import com.example.mobsofthw.models.util.NetworkHelper.checkNetworkConnection
import com.example.mobsofthw.scenes.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsListActivity : BaseActivity() {

    private val viewModel: NewsListViewModel by viewModel()

    override fun getContentView() = R.layout.activity_main

    override fun initUi() {
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        fetchNews()
    }

    private fun fetchNews() {
        viewModel.uiData.observe(this, Observer { newsList ->
            recyclerView.adapter = NewsListAdapter(newsList, applicationContext)
        })
        if (!checkNetworkConnection(this)) return
        viewModel.fetchNews()
    }
}
