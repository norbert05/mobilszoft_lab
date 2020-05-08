package com.example.mobsofthw.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.mobsofthw.models.dao.NewsEntity
import com.example.mobsofthw.models.util.NetworkResponse
import com.example.mobsofthw.repository.news.NewsDao
import com.example.mobsofthw.repository.news.NewsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface NewsRepository {
    suspend fun fetchNews()
    val newsLiveData: LiveData<List<NewsEntity>>
}

open class NewsRepositoryImpl(
    private val newsDto: NewsDto,
    private val newsDao: NewsDao
) : NewsRepository {

    override val newsLiveData: LiveData<List<NewsEntity>> = newsDao.getNews()

    override suspend fun fetchNews() {
        withContext(Dispatchers.IO) {
            val response = newsDto.fetchNews()
            if (response.isSuccessful) {
                val newsList = response.body()?.news
                val newsEntityList = newsList?.map {
                    NewsEntity(
                        id = it.id ?: "",
                        title = it.title,
                        description = it.description,
                        image = it.image,
                        language = it.language,
                        published = it.published,
                        url = it.url
                    )
                }
                persistNews(newsEntityList)
            }
        }
    }

    suspend fun persistNews(newsEntityList: List<NewsEntity>?) {
        newsEntityList?.let {
            newsDao.insertAll(it)
        }
    }
}