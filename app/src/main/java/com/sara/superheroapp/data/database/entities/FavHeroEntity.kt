package com.sara.superheroapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sara.superheroapp.domain.model.SuperheroItem


@Entity(tableName = "favhero_table")
data class FavHeroEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "idhero") val idhero: String

)

fun SuperheroItem.toEntityId() = FavHeroEntity(idhero = id)
