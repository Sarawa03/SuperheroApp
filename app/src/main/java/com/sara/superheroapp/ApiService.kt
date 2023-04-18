package com.sara.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/1663379674103013/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName:String):Response<SuperheroDataResponse>
}