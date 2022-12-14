package com.dttcaltekin.breakingbadapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dttcaltekin.breakingbadapp.domain.model.Quote
import com.dttcaltekin.breakingbadapp.repository.QuoteRepository
import com.dttcaltekin.breakingbadapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository
) : ViewModel() {

    val quoteList = MutableStateFlow<Resource<Quote>?>(null)

    fun getQuote(name: String) {
        quoteList.value = Resource.Loading()
        viewModelScope.launch {
            val request = quoteRepository.getDetail(name)
            quoteList.value = request
        }
    }
}