package com.example.pokedex.view.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.extensions.changeColor
import com.example.pokedex.extensions.hide
import com.example.pokedex.extensions.show
import com.example.pokedex.model.Pokemon
import com.example.pokedex.view.adapter.PokemonListAdapter
import com.example.pokedex.viewmodels.MainActivityViewModel
import com.example.pokedex.viewmodels.MainActivityViewModelFactory
import com.example.pokedex.viewstate.Error
import com.example.pokedex.viewstate.Loading
import com.example.pokedex.viewstate.Success
import com.example.pokedex.viewstate.ViewState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewmodelFactory by lazy { MainActivityViewModelFactory(this) }
    private val viewModel: MainActivityViewModel by viewModels {
        viewmodelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pokemonList: RecyclerView = findViewById(R.id.pokemon_recycler_view)
        pokemonList.layoutManager = GridLayoutManager(this, 2)

        val pokemonListAdapter = PokemonListAdapter(this)
        pokemonList.adapter = pokemonListAdapter

        //Create an observer which updates UI in after network calls
        viewModel.pokemonLiveData.observe(this, Observer<ViewState<List<Pokemon>>> { viewState ->
            when (viewState) {
                is Success -> {
                    main_progress_bar.hide()
                    pokemonListAdapter.setPokemonList(viewState.data)
                }
                is Error -> {
                    main_progress_bar.hide()
                    Toast.makeText(this, viewState.errMsg, Toast.LENGTH_SHORT).show()
                }
                is Loading -> {
                    main_progress_bar.show()
                }
            }

        })

        changeColor(getColor(R.color.colorPrimary))
    }
}