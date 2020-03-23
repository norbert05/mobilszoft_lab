package com.example.mobsofthw.scenes.newsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobsofthw.R

class NewsListActivity : AppCompatActivity() {

    private lateinit var presenter: NewsListPresenterInput

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeProperties()
    }

    private fun initializeProperties() {
        presenter = NewsListPresenter(this)
    }
}
