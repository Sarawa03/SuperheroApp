package com.sara.superheroapp.data.model

import com.google.gson.annotations.SerializedName
import com.sara.superheroapp.domain.model.SuperheroItem


data class SuperheroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperheroItem>?
)


