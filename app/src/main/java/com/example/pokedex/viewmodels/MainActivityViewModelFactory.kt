package com.example.pokedex.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.network.createPokemonService
import com.example.pokedex.persistence.AppDatabase
import com.example.pokedex.repository.MainRepository
import java.lang.IllegalArgumentException

class MainActivityViewModelFactory(private val context: Context) :ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(MainRepository(createPokemonService(), AppDatabase.getAppDatabase(context)!!.pokemonDao())) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }

}