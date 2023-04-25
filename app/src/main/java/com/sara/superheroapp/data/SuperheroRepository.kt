package com.sara.superheroapp.data


import com.sara.superheroapp.data.database.dao.FavHeroDao
import com.sara.superheroapp.data.database.entities.FavHeroEntity
import com.sara.superheroapp.data.network.SuperheroService
import com.sara.superheroapp.domain.model.Superhero
import com.sara.superheroapp.domain.model.SuperheroDetails
import com.sara.superheroapp.domain.model.toDomain
import javax.inject.Inject

class SuperheroRepository @Inject constructor(
    private val api: SuperheroService,
    private val favHeroDao: FavHeroDao

    ) {

    suspend fun getSuperheroesByName(name: String): Superhero { // TODO Devolvía una list, por qué ya no?

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


}