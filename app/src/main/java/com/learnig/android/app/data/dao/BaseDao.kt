package com.learnig.android.app.data.dao

import androidx.room.*


@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(t: T): Long

    @Update
    fun update(t: T)

    @Delete
    fun delete(t: T)
}