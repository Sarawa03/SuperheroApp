package com.sara.superheroapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sara.superheroapp.data.database.entities.toEntityId
import com.sara.superheroapp.domain.AddFavSuperhero
import com.sara.superheroapp.domain.GetAllFavs
import com.sara.superheroapp.domain.GetByNameUseCase
import com.sara.superheroapp.domain.RemoveFavSuperhero
import com.sara.superheroapp.domain.model.SuperheroItem
import com.sara.superheroapp.ui.view.recyclerview.SuperheroViewHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getByNameUseCase: GetByNameUseCase,
    private val addFavSuperhero: AddFavSuperhero,
    private val removeFavSuperhero: RemoveFavSuperhero,
    private val getAllFavs: GetAllFavs
): ViewModel(){

    val favoritesViewModel = MutableLiveData<List<SuperheroItem>>()

    fun showFavs() {
        viewModelScope.launch {
            val result = getAllFavs()

            favoritesViewModel.postValue(result)
            Log.i("PATATA", result.toString())
            SuperheroViewHolder.favorites.clear()
            result.forEach {SuperheroViewHolder.favorites.add(it.id) }
        }
    }

    fun addFavHero(superheroItem:SuperheroItem){
        viewModelScope.launch {
            addFavSuperhero(superheroItem.toEntityId())
            SuperheroViewHolder.favorites.add(superheroItem.id)
        }
    }

    fun unfavHero(superheroItem: String){
        viewModelScope.launch {
            removeFavSuperhero(superheroItem)
            SuperheroViewHolder.favorites.remove(superheroItem)
        }
    }

}