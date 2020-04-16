package com.example.mobsofthw.di

import com.example.mobsofthw.repository.NewsRepository
import com.example.mobsofthw.repository.NewsRepositoryImpl
import com.example.mobsofthw.scenes.newsDetail.NewsDetailViewModel
import com.example.mobsofthw.scenes.newsList.NewsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsModule = module {

    single<NewsRepository> { NewsRepositoryImpl(get(), get()) }

    viewModel { NewsListViewModel(get()) }

    viewModel { NewsDetailViewModel() }
}