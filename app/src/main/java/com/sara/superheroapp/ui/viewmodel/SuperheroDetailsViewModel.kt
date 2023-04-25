package com.sara.superheroapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sara.superheroapp.domain.GetSuperheroInformation
import com.sara.superheroapp.domain.model.SuperheroDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroDetailsViewModel @Inject constructor(
    private val getSuperheroInformation: GetSuperheroInformation
): ViewModel(){

    val superHeroDetailsModel = MutableLiveData<SuperheroDetails>()

    fun postSuperheroDetails(id: String){
        viewModelScope.launch {
            val  result = getSuperheroInformation(id)
            superHeroDetailsModel.postValue(result)
        }
    }

}