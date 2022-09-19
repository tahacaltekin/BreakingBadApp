package com.dttcaltekin.breakingbadapp.repository

import com.dttcaltekin.breakingbadapp.base.BaseRepository
import com.dttcaltekin.breakingbadapp.domain.service.BreakingBadAPI
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val api : BreakingBadAPI) : BaseRepository() {

    suspend fun getData() = safeApiRequest {
        api.getCharacters()
    }
}