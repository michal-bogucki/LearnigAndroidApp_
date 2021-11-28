package com.learnig.android.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learnig.android.app.data.models.character.Character
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao:BaseDao<Character> {

    @Query("SELECT * FROM ${Character.TABLE_NAME}")
    fun getAllCharacter(): Flow<List<Character>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListCharacter(list: List<Character>)

    @Query("SELECT * FROM ${Character.TABLE_NAME} WHERE id = :id")
    fun getCharacterById(id:Int): Flow<Character>



}