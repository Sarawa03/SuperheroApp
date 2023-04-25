package com.sara.superheroapp.data.model

import com.google.gson.annotations.SerializedName
import com.sara.superheroapp.domain.model.Biography
import com.sara.superheroapp.domain.model.PowerStatsResponse
import com.sara.superheroapp.domain.model.SuperheroImageDetailResponse

data class SuperHeroDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats : PowerStatsResponse,
    @SerializedName("image") val image : SuperheroImageDetailResponse,
    @SerializedName("biography") val biography: Biography
    //@SerializedName("") val :
)
