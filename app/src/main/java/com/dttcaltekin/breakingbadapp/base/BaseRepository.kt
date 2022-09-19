package com.dttcaltekin.breakingbadapp.base

import com.dttcaltekin.breakingbadapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepository {

    suspend fun <T> safeApiRequest(apiRequest: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.Success(apiRequest.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Resource.Error("Check Your Internet connection")
                    }
                    else -> Resource.Error(throwable.localizedMessage)
                }
            }
        }
    }
}