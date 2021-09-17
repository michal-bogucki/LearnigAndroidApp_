package com.learnig.android.app.di.room

import android.app.Application
import com.learnig.android.app.data.dao.CharacterDao
import com.learnig.android.app.data.dao.EpisodeDao
import com.learnig.android.app.data.dao.LocationDao
import com.learnig.android.app.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class DatabaseProvider {
    @Singleton
    @Provides
    fun provideDatabase(app: Application): AppDatabase {
        return AppDatabase.getDatabase(app)
    }

    @Singleton
    @Provides
    fun characterDao(db: AppDatabase): CharacterDao {
        return db.characterDao()
    }

    @Singleton
    @Provides
    fun locationDao(db: AppDatabase): LocationDao {
        return db.locationDao()
    }

    @Singleton
    @Provides
    fun episodeDao(db: AppDatabase): EpisodeDao {
        return db.episodeDao()
    }


}