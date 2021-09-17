package com.learnig.android.app.di.module


import com.learnig.android.app.data.remoteapi.RickAndMortyService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

import retrofit2.converter.moshi.MoshiConverterFactory

import javax.inject.Singleton



@InstallIn(SingletonComponent::class)
@Module
class ApiModule {
    @Singleton
    @Provides
    fun provideRickAndMortyService(): RickAndMortyService = Retrofit.Builder()
            .baseUrl(RickAndMortyService.API_URL)
            .addConverterFactory(
                    MoshiConverterFactory.create(
                            Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                    )
            )
            .build()
            .create(RickAndMortyService::class.java)
}