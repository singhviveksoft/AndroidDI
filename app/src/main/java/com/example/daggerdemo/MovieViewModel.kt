package com.example.daggerdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(val repository: MovieRepository) :ViewModel(){
    private var apiResult=MutableLiveData<Response<List<MovieModel>>>()
    val _apiResult:LiveData<Response<List<MovieModel>>>
        get() = apiResult



   /* init {
        getMovie()
    }
*/
    fun getMovie(){
        viewModelScope.launch {
            try {
                var response:Response<List<MovieModel>>?=null
                launch {
                    response   = repository.getMovie()
                    apiResult.value=response!!
                }


            }catch (ex:Exception){
                Log.i("main",ex.toString())
            }

        }

    }
}