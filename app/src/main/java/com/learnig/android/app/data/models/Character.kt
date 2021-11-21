package com.learnig.android.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@TypeConverters(Converters::class)
@Entity(tableName = "character")
data class Character(
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val origin: String,
    val location: String,
    val episode: List<String>,
    @PrimaryKey(autoGenerate = true)
    override val id: Int
) : Item