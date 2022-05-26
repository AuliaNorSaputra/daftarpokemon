package com.example.pokedex.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.network.createPokemonService
import com.example.pokedex.repository.DetailRepository
import java.lang.IllegalArgumentException

class DetailActivityViewModelFactory(private val context :Context) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailActivityViewModel::class.java)){
            return DetailActivityViewModel(DetailRepository(createPokemonService())) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }

}