package com.dttcaltekin.breakingbadapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dttcaltekin.breakingbadapp.domain.model.Character
import com.dttcaltekin.breakingbadapp.repository.CharacterRepository
import com.dttcaltekin.breakingbadapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    val characterList = MutableStateFlow<Resource<Character>?>(null)
    private val isLoading = MutableStateFlow<Boolean>(true)


    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            isLoading.value = true
            val request = characterRepository.getData()
            characterList.value = request
        }
    }
}