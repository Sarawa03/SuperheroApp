package com.sara.superheroapp.domain

import com.sara.superheroapp.data.SuperheroRepository
import javax.inject.Inject

class GetByNameUseCase @Inject constructor(
    private val repository: SuperheroRepository
){
    suspend operator fun invoke(name: String) = repository.getSuperheroesByName(name)
}