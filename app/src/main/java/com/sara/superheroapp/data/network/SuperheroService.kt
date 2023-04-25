package com.sara.superheroapp.data.network

import android.util.Log
import com.sara.superheroapp.data.database.dao.FavHeroDao
import com.sara.superheroapp.data.database.entities.FavHeroEntity
import com.sara.superheroapp.data.model.SuperHeroDetailResponse
import com.sara.superheroapp.data.model.SuperheroDataResponse
import com.sara.superheroapp.domain.model.Superhero
import com.sara.superheroapp.domain.model.SuperheroItem
import com.sara.superheroapp.domain.model.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SuperheroService @Inject constructor(private val api: ApiService) {

    suspend fun getSuperheroes(nombre: String): SuperheroDataResponse {

        return withContext(Dispatchers.IO) {
            //dao.deleteAllFav()
            val response = api.getSuperheroes(nombre)
            response.body()!!
        }
    }

    suspend fun getAllFavs(favorites: List<FavHeroEntity>): List<SuperheroItem>{

        val result: MutableList<SuperheroItem> = mutableListOf()

        favorites.forEach { result.add(api.getSuperheroesById(it.idhero).body()!!.toDomain()) }
        Log.i("PATATA", result.toString())
        return result
    }

    suspend fun getSuperheroInformation(id: String): SuperHeroDetailResponse {
        return withContext(Dispatchers.IO){
            val response = api.getSuperheroesDetail(id)
            response.body()!!
        }
    }
}