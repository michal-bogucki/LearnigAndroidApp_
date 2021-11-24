package com.learnig.android.app.data.remoteapi


import com.learnig.android.app.data.models.Episode
import com.learnig.android.app.data.models.Location
import com.learnig.android.app.data.models.character.CharacterApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("Character.json")
    suspend fun getCharacters(): Response<CharacterApi>

    @GET("Location.json")
    suspend fun getLocations(): Response<List<Location>>

    @GET("Episode.json")
    suspend fun getEpisodes(): Response<List<Episode>>


    companion object {
        const val API_URL = "https://michal-bogucki.github.io/"
    }
}