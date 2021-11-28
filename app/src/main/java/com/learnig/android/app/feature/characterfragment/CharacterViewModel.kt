package com.learnig.android.app.feature.characterfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learnig.android.app.data.models.character.Character
import com.learnig.android.app.data.repository.CharacterRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val characterRepository: CharacterRepositoryInterface) :
    ViewModel() {

    private val _character: MutableLiveData<Character> = MutableLiveData()
    val character: MutableLiveData<Character>
        get() = _character


    fun getCharacter(characterId: Int) {
        viewModelScope.launch {
            characterRepository.getCharacterById(characterId).collect {
                _character.value = it
            }
        }
    }


}