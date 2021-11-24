package com.learnig.android.app.feature.characterlistfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learnig.android.app.data.models.character.Character
import com.learnig.android.app.data.remoteapi.State
import com.learnig.android.app.data.repository.CharacterRepository
import com.learnig.android.app.data.repository.CharacterRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(private val characterRepository: CharacterRepositoryInterface) :ViewModel() {


    private val _characterList: MutableLiveData<State<List<Character>>> = MutableLiveData()
    val characterList: MutableLiveData<State<List<Character>>>
        get() = _characterList

    fun getCharacterList() {
        viewModelScope.launch {
            characterRepository.getCharacterList().map { resource ->
                State.fromResource(resource)
            }.collect { state ->
                _characterList.value = state
            }
        }
    }

}