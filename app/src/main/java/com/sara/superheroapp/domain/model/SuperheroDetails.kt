package com.sara.superheroapp.domain.model

import com.google.gson.annotations.SerializedName
import com.sara.superheroapp.data.model.SuperHeroDetailResponse

class SuperheroDetails (
    val name: String,
    val powerstats: PowerStatsResponse,
    val image: SuperheroImageDetailResponse,
    val biography: Biography
    )

data class PowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class SuperheroImageDetailResponse(@SerializedName("url") val url: String)

data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("publisher") val publisher: String,
)

fun SuperHeroDetailResponse.toDomain() = SuperheroDetails(name, powerstats, image, biography)