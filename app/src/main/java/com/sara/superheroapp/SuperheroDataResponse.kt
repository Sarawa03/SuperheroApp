package com.sara.superheroapp

import com.google.gson.annotations.SerializedName

//data class SuperheroDataResponse (@SerializedName("response") val pepe:String){
data class SuperheroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperheroItemResponse>
)

data class SuperheroItemResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    //@SerializedName("id") val superheroId: String,

)