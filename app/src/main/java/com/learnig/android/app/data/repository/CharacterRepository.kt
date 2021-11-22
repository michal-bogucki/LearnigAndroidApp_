package com.learnig.android.app.data.repository

import com.learnig.android.app.data.dao.CharacterDao
import com.learnig.android.app.data.models.Character
import com.learnig.android.app.data.remoteapi.NetworkBoundRepository
import com.learnig.android.app.data.remoteapi.Resource
import com.learnig.android.app.data.remoteapi.RickAndMortyService
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(val rickAndMortyService: RickAndMortyService,val characterDao: CharacterDao) {

//    fun getCharacterList(): Flow<Resource<Character>> {
//        return object : NetworkBoundRepository<AirQ, AirQRemote>() {
//            override suspend fun saveRemoteData(response: AirQRemote) {
//                val results = response.results?.mapNotNull { city ->
//                    if (city.city != null && city.coordinates != null)
//                        city
//                    else
//                        null
//                }
//                airQualityDao.insert(AirQ(0, results = results, LocalDateTime.now()))
//            }
//
//            override fun fetchFromLocal(): Flow<AirQ> = airQualityDao.getLastAirQ()
//
//            override suspend fun fetchFromRemote(): Response<AirQRemote> =
//                airQualityService.getAirQualityAsync(lastLocation, 100000,100)
//
//            override fun shouldFetch(data: AirQ?) = when {
//                data == null -> true
//                testTime(data.date, LocalDateTime.now(), 30) -> true
//                else -> false
//            }
//        }.asFlow()
//    }
}