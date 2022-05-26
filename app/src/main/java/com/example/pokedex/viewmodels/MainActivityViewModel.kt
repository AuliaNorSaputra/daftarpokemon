package com.example.pokedex.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.model.Pokemon
import com.example.pokedex.repository.MainRepository
import com.example.pokedex.viewstate.ViewState

class MainActivityViewModel(mainRepository : MainRepository) : ViewModel() {

    val pokemonLiveData : LiveData<ViewState<List<Pokemon>>> = mainRepository.pokemonListLiveData

    init {
        mainRepository.getPokemonList()
    }
}