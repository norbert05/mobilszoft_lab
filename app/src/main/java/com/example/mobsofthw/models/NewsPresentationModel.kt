package com.example.mobsofthw.models

import android.media.Image
import java.net.URI
import java.time.LocalDateTime

class NewsPresentationModel(val title: String,
                            val description: String,
                            val id: String,
                            val image: Image,
                            val language: String,
                            val published: String,
                            val url: String)