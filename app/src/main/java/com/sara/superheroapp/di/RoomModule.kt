package com.sara.superheroapp.di

import android.content.Context
import androidx.room.Room
import com.sara.superheroapp.data.database.FavHeroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DB_NAME = "SuperheroDB"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FavHeroDatabase::class.java, DB_NAME).build()

    @Singleton
    @Provides
    fun provideFavSuperheroDao(database: FavHeroDatabase) = database.getFavHeroDao()


}