package com.sara.superheroapp.domain

import com.sara.superheroapp.data.SuperheroRepository
import com.sara.superheroapp.data.database.entities.FavHeroEntity
import javax.inject.Inject

class RemoveFavSuperhero @Inject constructor(
    private val repository: SuperheroRepository
){
    suspend operator fun invoke(favHero:String) = repository.removeFavSuperhero(favHero)
}