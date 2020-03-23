package com.example.mobsofthw.scenes.newsList

import com.example.mobsofthw.models.News

class NewsListInteractor(override var presenter: NewsListPresenterInput): NewsListInteractorInput {
    override fun downloadNews(): List<News> {
        TODO("Not yet implemented")
    }
}