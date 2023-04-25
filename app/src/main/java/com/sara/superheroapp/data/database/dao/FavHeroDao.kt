package com.sara.superheroapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sara.superheroapp.data.database.entities.FavHeroEntity

@Dao
interface FavHeroDao {

    @Query("SELECT * FROM favhero_table")
    suspend fun getAllFavSuperheroes(): List<FavHeroEntity>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertFavSuperhero(favSuperheroId: FavHeroEntity)

    @Query("DELETE FROM favhero_table WHERE idhero = :favSuperheroId")
    suspend fun deleteFavSuperhero(favSuperheroId: String)

}