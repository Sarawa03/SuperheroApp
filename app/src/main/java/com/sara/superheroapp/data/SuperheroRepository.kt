package com.sara.superheroapp.data


import com.sara.superheroapp.data.database.dao.FavHeroDao
import com.sara.superheroapp.data.database.entities.FavHeroEntity
import com.sara.superheroapp.data.model.SuperHeroDetailResponse
import com.sara.superheroapp.data.model.SuperheroDataResponse
import com.sara.superheroapp.data.network.SuperheroService
import com.sara.superheroapp.domain.model.Superhero
import com.sara.superheroapp.domain.model.SuperheroDetails
import com.sara.superheroapp.domain.model.SuperheroItem
import com.sara.superheroapp.domain.model.toDomain
import javax.inject.Inject

class SuperheroRepository @Inject constructor(
    private val api: SuperheroService,
    private val favHeroDao: FavHeroDao

    ) {

    suspend fun getSuperheroesByName(name: String): Superhero {

        return api.getSuperheroes(name).toDomain()

    }

    suspend fun getSuperheroInformation(id: String): SuperheroDetails{
        return api.getSuperheroInformation(id).toDomain()
    }

    suspend fun addFavSuperhero(favHero: FavHeroEntity){
        favHeroDao.insertFavSuperhero(favHero)
    }

    suspend fun removeFavSuperhero(favHero: String) {
        favHeroDao.deleteFavSuperhero(favHero)
    }

    suspend fun getAllFavs(): List<SuperheroItem>{
        return api.getAllFavs(favHeroDao.getAllFavSuperheroes().orEmpty())

    }




}