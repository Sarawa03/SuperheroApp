package com.sara.superheroapp.domain

import com.sara.superheroapp.data.SuperheroRepository
import com.sara.superheroapp.data.database.entities.FavHeroEntity
import com.sara.superheroapp.data.model.SuperheroDataResponse
import com.sara.superheroapp.domain.model.Superhero
import com.sara.superheroapp.domain.model.SuperheroItem
import javax.inject.Inject

class GetAllFavs @Inject constructor(
    private val repository: SuperheroRepository
){

    suspend operator fun invoke(): List<SuperheroItem> = repository.getAllFavs()
}