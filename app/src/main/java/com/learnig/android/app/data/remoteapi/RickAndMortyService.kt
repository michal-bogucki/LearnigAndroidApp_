package com.learnig.android.app.data.remoteapi


import com.learnig.android.app.data.models.Character
import com.learnig.android.app.data.models.Episode
import com.learnig.android.app.data.models.Location
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyService {

    @GET("character")
    suspend fun getCharacters(): Response<Character>

    @GET("location")
    suspend fun getLocations(): Response<Location>

    @GET("episode")
    suspend fun getEpisodes(): Response<Episode>


    companion object {
        const val API_URL = "https://rickandmortyapi.com/api/"
    }
}