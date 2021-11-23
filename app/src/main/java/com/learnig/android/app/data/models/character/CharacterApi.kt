package com.learnig.android.app.data.models.character

import com.learnig.android.app.data.models.Info
import com.squareup.moshi.Json


data class CharacterApi(
    @Json(name = "info")
    val info: Info,
    @Json(name = "results")
    val results: List<Character>

)