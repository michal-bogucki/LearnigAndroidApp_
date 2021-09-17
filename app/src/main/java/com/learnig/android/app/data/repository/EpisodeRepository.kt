package com.learnig.android.app.data.repository

import com.learnig.android.app.data.dao.EpisodeDao
import com.learnig.android.app.data.remoteapi.RickAndMortyService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EpisodeRepository @Inject constructor(val rickAndMortyService: RickAndMortyService,val episodeDao: EpisodeDao) {
}