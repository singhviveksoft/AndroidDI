package com.example.daggerdemo

import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.Response
import javax.inject.Inject
@ActivityRetainedScoped
class MovieRepository @Inject constructor(
        private val remoteDatasource: RemoteDatasource
){
    suspend fun getMovie() = remoteDatasource.getMovie()
}