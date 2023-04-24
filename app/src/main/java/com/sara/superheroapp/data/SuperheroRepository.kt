package com.sara.superheroapp.data


import com.sara.superheroapp.data.network.SuperheroService
import com.sara.superheroapp.domain.model.Superhero
import com.sara.superheroapp.domain.model.toDomain
import javax.inject.Inject

class SuperheroRepository @Inject constructor(

    private val api: SuperheroService,

    ) {

    suspend fun getSuperheroesByName(name: String): Superhero { // TODO Devolvía una list, por qué ya no?

        return api.getSuperheroes(name).toDomain()

    }

}