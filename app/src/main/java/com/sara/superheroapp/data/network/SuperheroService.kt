package com.sara.superheroapp.data.network

import com.sara.superheroapp.data.model.SuperheroDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SuperheroService @Inject constructor(private val api: ApiService) {

    suspend fun getSuperheroes(nombre: String): SuperheroDataResponse {
        return withContext(Dispatchers.IO) {
            val response = api.getSuperheroes(nombre)
            response.body()!!
        }
    }
}