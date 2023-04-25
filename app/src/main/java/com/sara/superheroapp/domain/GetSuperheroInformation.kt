package com.sara.superheroapp.domain

import com.sara.superheroapp.data.SuperheroRepository
import javax.inject.Inject

class GetSuperheroInformation @Inject constructor(
    private val repository: SuperheroRepository
){

    suspend operator fun invoke(id: String) = repository.getSuperheroInformation(id)
}