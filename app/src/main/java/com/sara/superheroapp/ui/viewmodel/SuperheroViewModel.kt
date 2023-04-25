package com.sara.superheroapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sara.superheroapp.data.database.entities.toEntityId
import com.sara.superheroapp.domain.AddFavSuperhero
import com.sara.superheroapp.domain.GetByNameUseCase
import com.sara.superheroapp.domain.RemoveFavSuperhero
import com.sara.superheroapp.domain.model.Superhero
import com.sara.superheroapp.domain.model.SuperheroItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroViewModel @Inject constructor(
    private val getByNameUseCase: GetByNameUseCase,
    private val addFavSuperhero: AddFavSuperhero,
    private val removeFavSuperhero: RemoveFavSuperhero

): ViewModel() {

    val superHeroModel = MutableLiveData<List<SuperheroItem>>()
    val isLoading = MutableLiveData<Boolean>()

    fun searchSuperheroByName(query: String){
        viewModelScope.launch {

            val result = getByNameUseCase(query)
            if(result.response == "error"){
                superHeroModel.postValue(emptyList())
            }else{
                superHeroModel.postValue(result.superheroes!!)
            }

        }
    }

    fun addFavHero(superheroItem:SuperheroItem){
        viewModelScope.launch {
            addFavSuperhero(superheroItem.toEntityId())
        }
    }

    fun unfavHero(superheroItem: String){
        viewModelScope.launch {
            removeFavSuperhero(superheroItem)
        }
    }

}