package com.example.mobsofthw.di

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mobsofthw.models.dao.NewsEntity
import com.example.mobsofthw.repository.news.NewsDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localSourceModule = module {
    // provided room components
    single {
        Room.databaseBuilder(androidApplication(), NewsDataBase::class.java, "news-db")
            .fallbackToDestructiveMigration()
            .build()
    }
    // provided news dao
    single {
        get<NewsDataBase>().newsDao()
    }
}

@Database(entities = [NewsEntity::class], version = 2)
abstract class NewsDataBase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}