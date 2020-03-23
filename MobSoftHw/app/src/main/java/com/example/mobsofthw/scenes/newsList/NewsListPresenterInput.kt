package com.example.mobsofthw.scenes.newsList

import com.example.mobsofthw.models.NewsPresentationModel

interface NewsListPresenterInput {
    fun fetchNews(): List<NewsPresentationModel>
}