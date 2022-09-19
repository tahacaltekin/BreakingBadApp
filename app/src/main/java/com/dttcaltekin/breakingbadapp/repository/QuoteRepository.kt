package com.dttcaltekin.breakingbadapp.repository

import com.dttcaltekin.breakingbadapp.base.BaseRepository
import com.dttcaltekin.breakingbadapp.domain.service.BreakingBadAPI
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api : BreakingBadAPI) : BaseRepository() {

    suspend fun getDetail(
        name : String
    ) = safeApiRequest {
        api.getQuote(name)
    }
}