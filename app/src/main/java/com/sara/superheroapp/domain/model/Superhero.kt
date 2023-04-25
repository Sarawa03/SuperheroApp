package com.sara.superheroapp.domain.model

import com.google.gson.annotations.SerializedName
import com.sara.superheroapp.data.model.SuperheroDataResponse

data class Superhero(
    val response: String,
    val superheroes: List<SuperheroItem>?
)

data class SuperheroItem(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: SuperheroImage,
    var isFav: Boolean = false
)

data class SuperheroImage(
    val url: String
)

fun SuperheroDataResponse.toDomain() = Superhero(response, superheroes)