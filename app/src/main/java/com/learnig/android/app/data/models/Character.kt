package com.learnig.android.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "character")
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val origin: String,
    val location: String,
    val episode: List<String>
)