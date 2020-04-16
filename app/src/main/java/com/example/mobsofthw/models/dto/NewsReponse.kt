package com.example.mobsofthw.models.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class NewsResponse(
    @SerializedName("id")
    @Expose var id: String? = null,
    @SerializedName("title")
    @Expose var title: String? = null,
    @SerializedName("description")
    @Expose var description: String? = null,
    @SerializedName("image")
    @Expose var image: String? = null,
    @SerializedName("language")
    @Expose var language: String? = null,
    @SerializedName("published")
    @Expose var published: String? = null,
    @SerializedName("url")
    @Expose var url: String? = null
)