package com.learnig.android.app.di.module

import com.learnig.android.app.data.repository.CharacterRepository
import com.learnig.android.app.data.repository.CharacterRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped


@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class CharacterRepositoryModule {
    @ActivityRetainedScoped
    @Binds
    abstract fun bindCharacterRepositoryInterface(repository:CharacterRepository):CharacterRepositoryInterface
}