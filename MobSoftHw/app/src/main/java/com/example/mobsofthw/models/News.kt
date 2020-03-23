package com.example.mobsofthw.models

import java.net.URI
import java.time.LocalDateTime

class News(val title: String,
           val description: String,
           val id: String,
           val image: URI,
           val language: String,
           val published: LocalDateTime,
           val url: String)