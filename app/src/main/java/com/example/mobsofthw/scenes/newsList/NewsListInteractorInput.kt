package com.example.mobsofthw.scenes.newsList

import com.example.mobsofthw.models.News

interface NewsListInteractorInput {
    var presenter: NewsListPresenterInput

    fun downloadNews(): List<News>
}