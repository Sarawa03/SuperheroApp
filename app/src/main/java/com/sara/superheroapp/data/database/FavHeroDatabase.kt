package com.sara.superheroapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sara.superheroapp.data.database.dao.FavHeroDao
import com.sara.superheroapp.data.database.entities.FavHeroEntity

@Database(entities = [FavHeroEntity::class], version = 1)
abstract class FavHeroDatabase: RoomDatabase(){

    abstract  fun getFavHeroDao(): FavHeroDao
}