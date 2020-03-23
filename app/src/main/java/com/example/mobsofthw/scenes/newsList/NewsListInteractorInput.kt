package com.example.mobsofthw.scenes.newsList

import com.example.mobsofthw.models.News

interface NewsListInteractorInput {
    fun downloadNews(): List<News>
}