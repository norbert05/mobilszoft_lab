package com.example.mobsofthw.scenes.newsList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobsofthw.R
import com.example.mobsofthw.models.dao.NewsEntity

class NewsViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var titleTextView: TextView? = null
    private var descriptionTextView: TextView? = null
    private var imageView: ImageView? = null
    private var dateTextView: TextView? = null


    init {
        titleTextView = itemView.findViewById(R.id.titleTextView)
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView)
        imageView = itemView.findViewById(R.id.imageView)
        dateTextView = itemView.findViewById(R.id.dateTextView)
    }

    fun bind(news: NewsEntity) {
        titleTextView!!.text = news.title
        descriptionTextView!!.text = news.description
        dateTextView!!.text = news.published
    }

}

class NewsListAdapter(private val list: List<NewsEntity>): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news: NewsEntity = list[position]
        holder.bind(news)
    }
}