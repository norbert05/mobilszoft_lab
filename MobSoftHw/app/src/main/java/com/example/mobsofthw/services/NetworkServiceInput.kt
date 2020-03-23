package com.example.mobsofthw.services

import android.graphics.Bitmap
import com.example.mobsofthw.models.News
import java.net.URI

interface NetworkServiceInput {
    fun getNews(): List<News>
    fun getImage(url: URI): Bitmap
}