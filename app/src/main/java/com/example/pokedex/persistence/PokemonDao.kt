package com.example.pokedex.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pokedex.model.Pokemon

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPokemons(pokemons : List<Pokemon>)

    @Update
    fun updatePokemon(pokemon : Pokemon)

    @Delete
    fun deletePokemon(pokemon : Pokemon)

    @Query("SELECT * FROM Pokemon WHERE name == :name")
    fun getPokemonByName(name :  String) : LiveData<List<Pokemon>>

    @Query("SELECT * FROM Pokemon")
    fun getPokemons() : List<Pokemon>

}