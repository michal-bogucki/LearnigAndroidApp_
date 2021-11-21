package com.learnig.android.app.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location")
data class Location(
    @PrimaryKey(autoGenerate = true)
    override val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val url: String
) : Item
