package com.example.mobsofthw.repository.news

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mobsofthw.models.dao.NewsEntity

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getNews(): LiveData<List<NewsEntity>>

    @Query("SELECT * from news WHERE id = :id")
    fun getNewsById(id: String): LiveData<NewsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(newList: List<NewsEntity>)

    @Insert
    suspend fun insertNews(newsEntity: NewsEntity)

    @Update
    suspend fun updateNews(newsEntity: NewsEntity)

    @Delete
    suspend fun deleteNews(newsEntity: NewsEntity)
}
