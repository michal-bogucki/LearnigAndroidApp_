package com.learnig.android.app.data.remoteapi


import com.learnig.android.app.data.models.Episode
import com.learnig.android.app.data.models.Location
import com.learnig.android.app.data.models.character.CharacterApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("/api/character")
    suspend fun getCharacters(): Response<CharacterApi>

    @GET("/api/character")
    suspend fun getNextCharacters(@Query("page") page: String): Response<CharacterApi>

    @GET("/api/location")
    suspend fun getLocations(): Response<List<Location>>

    @GET("/api/episode")
    suspend fun getEpisodes(): Response<List<Episode>>


    companion object {
        const val API_URL = "https://rickandmortyapi.com/"
    }
}