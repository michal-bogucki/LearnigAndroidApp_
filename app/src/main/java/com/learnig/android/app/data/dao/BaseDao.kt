package com.learnig.android.app.data.dao

import androidx.room.*


@Dao
interface BaseDao<T> {



    @Update
    fun update(t: T)

    @Delete
    fun delete(t: T)
}