package com.example.mobsofthw.repository.news

import com.example.mobsofthw.di.DatasourceProperties
import com.example.mobsofthw.models.dto.NewsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsDto {
    @GET("latest-news")
    @Headers("Content-type: application/json")
    suspend fun fetchNews(@Query("apiKey") apiKey: String = DatasourceProperties.API_KEY): Response<NewsListResponse>
}