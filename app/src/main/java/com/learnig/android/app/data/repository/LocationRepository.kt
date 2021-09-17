package com.learnig.android.app.data.repository

import com.learnig.android.app.data.dao.LocationDao
import com.learnig.android.app.data.remoteapi.RickAndMortyService
import javax.inject.Inject

class LocationRepository  @Inject constructor(val rickAndMortyService: RickAndMortyService, val locationDao: LocationDao) {
}