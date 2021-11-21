package com.learnig.android.app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.learnig.android.app.data.dao.CharacterDao
import com.learnig.android.app.data.dao.EpisodeDao
import com.learnig.android.app.data.dao.LocationDao
import com.learnig.android.app.data.models.Character
import com.learnig.android.app.data.models.Converters
import com.learnig.android.app.data.models.Episode
import com.learnig.android.app.data.models.Location
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@TypeConverters(Converters::class)
@Database(entities = [Character::class, Location::class, Episode::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
    abstract fun episodeDao(): EpisodeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = init(context)
                INSTANCE = instance
                instance
            }
        }

        private fun init(context: Context): AppDatabase {
            return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "Database")
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val database = getDatabase(context)
                        GlobalScope.launch { database.initDatabase(context) }
                    }
                })
                .build()
        }
    }

    suspend fun initDatabase(context: Context) {

    }

}