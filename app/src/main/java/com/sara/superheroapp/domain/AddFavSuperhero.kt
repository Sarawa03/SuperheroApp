package com.sara.superheroapp.domain

import com.sara.superheroapp.data.SuperheroRepository
import com.sara.superheroapp.data.database.entities.FavHeroEntity
import javax.inject.Inject

class AddFavSuperhero @Inject constructor(
    private val repository: SuperheroRepository
){
    suspend operator fun invoke(favHero: FavHeroEntity) = repository.addFavSuperhero(favHero)
}