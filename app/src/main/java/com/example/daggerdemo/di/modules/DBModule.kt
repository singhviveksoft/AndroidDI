package com.example.daggerdemo.di.modules

import android.content.Context
import androidx.room.Room
import com.example.daggerdemo.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun getDbModuke(
            @ApplicationContext context:Context
    )=Room.databaseBuilder(context,MovieDataBase::class.java,"movie_db").build()
}