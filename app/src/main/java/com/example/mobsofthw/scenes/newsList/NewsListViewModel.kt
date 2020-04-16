package com.example.mobsofthw.scenes.newsList

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobsofthw.models.dao.NewsEntity
import com.example.mobsofthw.repository.NewsRepository
import kotlinx.coroutines.launch

class NewsListViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    val uiData: LiveData<List<NewsEntity>> = newsRepository.newsLiveData

    fun fetchNews() = viewModelScope.launch { newsRepository.fetchNews() }
}

data class NewsUIModel(val list: List<NewsEntity> = emptyList(), val error: Throwable? = null)

data class NewsPresentationModel(
    val title: String? = null,
    val description: String? = null,
    val id: String? = null,
    val image: Image? = null,
    val language: String? = null,
    val published: String? = null,
    val url: String? = null
)