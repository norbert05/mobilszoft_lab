package com.example.mobsofthw.models.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class NewsListResponse(
    @SerializedName("news")
    @Expose var news: List<NewsResponse>? = null
)