package com.example.mobsofthw.scenes.newsList

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobsofthw.R
import com.example.mobsofthw.models.dao.NewsEntity
import com.example.mobsofthw.scenes.newsDetail.NewsDetailActivity
import com.squareup.picasso.Picasso

class NewsViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var titleTextView: TextView? = null
    private var descriptionTextView: TextView? = null
    private var imageView: ImageView? = null
    private var dateTextView: TextView? = null
    var layout: LinearLayout? = null

    init {
        titleTextView = itemView.findViewById(R.id.titleTextView)
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView)
        imageView = itemView.findViewById(R.id.imageView)
        dateTextView = itemView.findViewById(R.id.dateTextView)

        layout = itemView.findViewById(R.id.linearLayout)
    }

    fun bind(news: NewsEntity) {
        titleTextView!!.text = news.title
        descriptionTextView!!.text = news.description
        dateTextView!!.text = news.published

        Picasso.get().load(news.image).into(imageView)
        println(news.image)
    }
}

class NewsListAdapter(private val list: List<NewsEntity>, private val context: Context): RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news: NewsEntity = list[position]
        holder.bind(news)

        holder.layout!!.setOnClickListener {
            val intent: Intent = Intent(context, NewsDetailActivity::class.java)
            intent.putExtra("url", news.url)
            intent.putExtra("title", news.title)
            it.context.startActivity(intent)
        }
    }
}