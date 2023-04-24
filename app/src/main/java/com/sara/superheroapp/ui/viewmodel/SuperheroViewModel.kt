package com.sara.superheroapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sara.superheroapp.domain.GetByNameUseCase
import com.sara.superheroapp.domain.model.Superhero
import com.sara.superheroapp.domain.model.SuperheroItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroViewModel @Inject constructor(
    private val getByNameUseCase: GetByNameUseCase

): ViewModel() {

    val superHeroModel = MutableLiveData<List<SuperheroItem>>() //No se puede acceder(?)
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

}