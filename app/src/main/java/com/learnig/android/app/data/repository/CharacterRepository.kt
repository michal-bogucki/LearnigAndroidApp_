package com.learnig.android.app.data.repository

import com.learnig.android.app.data.dao.CharacterDao
import com.learnig.android.app.data.models.character.Character
import com.learnig.android.app.data.models.character.CharacterApi
import com.learnig.android.app.data.remoteapi.NetworkBoundRepository
import com.learnig.android.app.data.remoteapi.Resource
import com.learnig.android.app.data.remoteapi.RickAndMortyService
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface CharacterRepositoryInterface{
    fun getCharacterList(): Flow<Resource<List<Character>>>
}


class CharacterRepository @Inject constructor(val rickAndMortyService: RickAndMortyService,val characterDao: CharacterDao):CharacterRepositoryInterface {

    override fun getCharacterList(): Flow<Resource<List<Character>>> {
        return object : NetworkBoundRepository<List<Character>, CharacterApi>() {
            override suspend fun saveRemoteData(characterApi: CharacterApi) {
                characterDao.insertListCharacter(characterApi.results)
            }

            override fun fetchFromLocal(): Flow<List<Character>> = characterDao.getAllCharacter()

            override suspend fun fetchFromRemote(): Response<CharacterApi> {
                return rickAndMortyService.getCharacters()
            }


            override fun shouldFetch(data: List<Character>?) = true
        }.asFlow()
    }
}