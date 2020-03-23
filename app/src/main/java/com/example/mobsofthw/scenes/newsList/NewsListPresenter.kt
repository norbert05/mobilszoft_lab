package com.example.mobsofthw.scenes.newsList

import com.example.mobsofthw.models.NewsPresentationModel

class NewsListPresenter(override var activity: NewsListActivity): NewsListPresenterInput {

    private var interactor: NewsListInteractorInput = NewsListInteractor(this)

    override fun fetchNews(): List<NewsPresentationModel> {
        TODO("Not yet implemented")
    }
}