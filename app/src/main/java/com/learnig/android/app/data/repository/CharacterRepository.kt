package com.learnig.android.app.data.repository

import com.learnig.android.app.data.dao.CharacterDao
import com.learnig.android.app.data.remoteapi.RickAndMortyService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(val rickAndMortyService: RickAndMortyService,val characterDao: CharacterDao) {
}