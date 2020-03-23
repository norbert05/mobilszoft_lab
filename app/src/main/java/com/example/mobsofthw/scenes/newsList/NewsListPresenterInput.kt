package com.example.mobsofthw.scenes.newsList

import com.example.mobsofthw.models.NewsPresentationModel

interface NewsListPresenterInput {
    var activity: NewsListActivity

    fun fetchNews(): List<NewsPresentationModel>
}