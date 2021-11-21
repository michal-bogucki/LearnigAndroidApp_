package com.learnig.android.app.data.models

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*


class Converters {

    @TypeConverter
    internal fun fromCharacterLIstToDb(optionValues: MutableList<String>?): String {
        val type = object : TypeToken<MutableList<String>>() {}.type
        return Gson().toJson(optionValues, type)
    }

    @TypeConverter
    internal fun fromDbToCharacterList(optionValuesString: String?): MutableList<String> {
        val type = object : TypeToken<MutableList<String>>() {}.type
        return Gson().fromJson<MutableList<String>>(optionValuesString, type)
    }


}

