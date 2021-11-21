package com.learnig.android.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@TypeConverters(Converters::class)
@Entity(tableName = "episode")
data class Episode(
    @PrimaryKey(autoGenerate = true)
    override val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String>,
    val url: String,
    val created: String
) :Item
