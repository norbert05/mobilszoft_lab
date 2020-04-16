package com.example.mobsofthw.models.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey @ColumnInfo(name = "id") var id: String,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "description") var description: String?,
    @ColumnInfo(name = "image") var image: String?,
    @ColumnInfo(name = "language") var language: String?,
    @ColumnInfo(name = "published") var published: String?,
    @ColumnInfo(name = "url") var url: String?
)