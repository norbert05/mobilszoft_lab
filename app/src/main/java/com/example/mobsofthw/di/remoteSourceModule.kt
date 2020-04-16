package com.example.mobsofthw.di

import com.example.mobsofthw.di.DatasourceProperties.SERVER_URL
import com.example.mobsofthw.repository.news.NewsDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteSourceModule = module {
    // provided web components
    single { createOkHttpClient() }

    // provided web service
    single { createWebService<NewsDto>(get(), SERVER_URL) }
}

object DatasourceProperties {
    const val SERVER_URL = "https://api.currentsapi.services/v1/"
    const val API_KEY = "g_HnHfDM5JA2rWq5j4hvuIg_ow1mUrpAGTt4RKOZPkjIxOrF"
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
    return retrofit.create(T::class.java)
}