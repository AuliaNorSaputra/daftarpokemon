package com.example.pokedex.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.model.PokemonInfo
import com.example.pokedex.repository.DetailRepository
import com.example.pokedex.viewstate.ViewState


class DetailActivityViewModel(private val detailRepository: DetailRepository) : ViewModel() {

    val pokemonInfoData : LiveData<ViewState<PokemonInfo>> = detailRepository.pokemonDetailsLiveData


    fun fetchPokemonDetails(name: String) {
        detailRepository.getPokemonDetails(name)
    }

}