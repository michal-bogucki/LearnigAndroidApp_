package com.learnig.android.app.data.models

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learnig.android.app.data.models.character.LocationApi
import com.learnig.android.app.data.models.character.OriginApi


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

    @TypeConverter
    internal fun fromOriginToDb(optionValues: OriginApi?): String {
        val type = object : TypeToken<OriginApi>() {}.type
        return Gson().toJson(optionValues, type)
    }

    @TypeConverter
    internal fun fromDbToOrigin(optionValuesString: String?): OriginApi {
        val type = object : TypeToken<OriginApi>() {}.type
        return Gson().fromJson<OriginApi>(optionValuesString, type)
    }


    @TypeConverter
    internal fun fromLocationToDb(optionValues: LocationApi?): String {
        val type = object : TypeToken<LocationApi>() {}.type
        return Gson().toJson(optionValues, type)
    }

    @TypeConverter
    internal fun fromDbToLocation(optionValuesString: String?): LocationApi {
        val type = object : TypeToken<LocationApi>() {}.type
        return Gson().fromJson<LocationApi>(optionValuesString, type)
    }
}

