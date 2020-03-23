package com.example.mobsofthw.services

import android.graphics.Bitmap
import com.example.mobsofthw.models.News
import java.net.URI

class NetworkService: NetworkServiceInput {
    override fun getNews(): List<News> {
        TODO("Not yet implemented")
    }

    override fun getImage(url: URI): Bitmap {
        TODO("Not yet implemented")
    }
}