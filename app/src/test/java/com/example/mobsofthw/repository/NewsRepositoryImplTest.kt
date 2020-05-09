package com.example.mobsofthw.repository

import com.example.mobsofthw.models.dao.NewsEntity
import com.example.mobsofthw.models.dto.NewsListResponse
import com.example.mobsofthw.models.dto.NewsResponse
import com.example.mobsofthw.repository.news.NewsDao
import com.example.mobsofthw.repository.news.NewsDto
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.Before
import retrofit2.Response

class NewsRepositoryImplTest {

    private val dao: NewsDao = mockk(relaxed = true)
    private val dto: NewsDto = mockk(relaxed = true)
    private val newsRepository: NewsRepository = NewsRepositoryImpl(dto, dao)

    private val response: Response<NewsListResponse> = mockk(relaxed = true)
    private val newsEntityList: List<NewsEntity> = mockk(relaxed = true)

    @Before
    fun init() {
        clearAllMocks()
        coEvery { dto.fetchNews() } returns response
    }

    @Test
    fun getNewsLiveData() {
    }

    @Test
    fun fetchNewsTest() = runBlocking {
        coEvery { newsRepository.fetchNews() } returns Unit
        coVerify { dto.fetchNews() }
    }

    @Test
    fun persistNews() = runBlocking {
        coEvery { newsRepository.fetchNews() }
        coVerify { dao.insertAll(newsEntityList) }
    }
}