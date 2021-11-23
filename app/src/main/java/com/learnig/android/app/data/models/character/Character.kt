package com.learnig.android.app.data.models.character

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.learnig.android.app.data.models.Converters
import com.learnig.android.app.data.models.Item
import com.learnig.android.app.data.models.character.Character.Companion.TABLE_NAME
import com.squareup.moshi.Json

@TypeConverters(Converters::class)
@Entity(tableName = TABLE_NAME)
data class Character(
    @Json(name = "name")
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val origin: OriginApi,
    val location: LocationApi,
    val episode: List<String>,
    @PrimaryKey(autoGenerate = true)
    override val id: Int
) : Item {
    companion object {
        const val TABLE_NAME = "character"
    }
}