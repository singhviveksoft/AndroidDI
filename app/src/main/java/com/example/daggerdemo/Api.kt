package com.example.daggerdemo

import retrofit2.Response
import retrofit2.http.GET

interface ApiService{

    @GET("movielist.json")
    suspend fun getMovie():Response<List<MovieModel>>
}