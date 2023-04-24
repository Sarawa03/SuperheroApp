package com.sara.superheroapp.data.model

import com.google.gson.annotations.SerializedName
import com.sara.superheroapp.domain.model.SuperheroItem

//data class SuperheroDataResponse (@SerializedName("response") val pepe:String){
data class SuperheroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperheroItem>?
)

//data class SuperheroItemResponse(
//    @SerializedName("id") val superheroId: String,
//    @SerializedName("name") val name: String,
//    @SerializedName("image") val superheroImage: SuperheroImageResponse,
//
//)
//
//data class  SuperheroImageResponse(@SerializedName("url") val url: String)

