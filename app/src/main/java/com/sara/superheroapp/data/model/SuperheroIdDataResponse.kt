package com.sara.superheroapp.data.model

import com.sara.superheroapp.domain.model.SuperheroImage

data class SuperheroIdDataResponse (
    val response: String,
    val id: String,
    val name: String,
    val image: SuperheroImage
)
