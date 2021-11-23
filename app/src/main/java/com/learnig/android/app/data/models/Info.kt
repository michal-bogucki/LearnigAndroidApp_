package com.learnig.android.app.data.models

import com.squareup.moshi.Json

data class Info(
    @Json(name = "count")
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
