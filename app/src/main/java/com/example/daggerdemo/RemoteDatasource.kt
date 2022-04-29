package com.example.daggerdemo

import javax.inject.Inject

class RemoteDatasource @Inject constructor(val api:ApiService) {

    suspend fun getMovie() = api.getMovie()

}