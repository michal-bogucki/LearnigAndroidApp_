package com.learnig.android.app.feature.characterlistfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learnig.android.app.data.models.Character
import com.learnig.android.app.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(private val characterRepository: CharacterRepository) :ViewModel() {


    private val _characterList: MutableLiveData<MutableList<Character>> = MutableLiveData()
    val characterList: MutableLiveData<MutableList<Character>>
        get() = _characterList

    fun getCharacterList(){
        viewModelScope.launch {

        }
    }

}