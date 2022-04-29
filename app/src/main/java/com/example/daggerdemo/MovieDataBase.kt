package com.example.daggerdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [MovieModel::class],version = 1,exportSchema = false)
abstract class MovieDataBase:RoomDatabase() {
    abstract val movieDao: MovieDao

    companion object {

        @Volatile
        private var INSTANCE: MovieDataBase? = null

        fun getInstance(context: Context): MovieDataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            MovieDataBase::class.java,
                            "movie_database")
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}