package com.dttcaltekin.breakingbadapp.domain.service

import com.dttcaltekin.breakingbadapp.domain.model.Character
import com.dttcaltekin.breakingbadapp.domain.model.CharacterItem
import com.dttcaltekin.breakingbadapp.domain.model.Quote
import com.dttcaltekin.breakingbadapp.utils.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface BreakingBadAPI {

    @GET("characters")
    suspend fun getCharacters() : Character

    @GET("quote")
    suspend fun getQuote(
        @Query("author") name : String) : Quote
}