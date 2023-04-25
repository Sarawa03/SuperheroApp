package com.sara.superheroapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sara.superheroapp.data.database.dao.FavHeroDao
import com.sara.superheroapp.data.database.entities.toEntityId
import com.sara.superheroapp.domain.AddFavSuperhero
import com.sara.superheroapp.domain.GetAllFavs
import com.sara.superheroapp.domain.GetByNameUseCase
import com.sara.superheroapp.domain.RemoveFavSuperhero
import com.sara.superheroapp.domain.model.Superhero
import com.sara.superheroapp.domain.model.SuperheroItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroViewModel @Inject constructor(
    private val getByNameUseCase: GetByNameUseCase,
    private val addFavSuperhero: AddFavSuperhero,
    private val removeFavSuperhero: RemoveFavSuperhero,
    private val favHeroDao: FavHeroDao
//    private val getAllFavs: GetAllFavs
): ViewModel() {

    val superHeroModel = MutableLiveData<List<SuperheroItem>>()
    val isLoading = MutableLiveData<Boolean>()

    fun searchSuperheroByName(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            //TODO - Comprobación de fav
            val result = getByNameUseCase(query)
            if(result.response == "error"){
                superHeroModel.postValue(emptyList())
            }else{
                superHeroModel.postValue(result.superheroes!!)
            }

        }
    }

    fun addFavHero(superheroItem:SuperheroItem){
        CoroutineScope(Dispatchers.IO).launch {
            Log.i("PATATA", superheroItem.toEntityId().toString())
            addFavSuperhero(superheroItem.toEntityId())
            Log.i("PATATA", favHeroDao.getAllFavSuperheroes().toString())
        }
    }

    fun unfavHero(superheroItem: String){
        CoroutineScope(Dispatchers.IO).launch {
            removeFavSuperhero(superheroItem)
        }
    }



}