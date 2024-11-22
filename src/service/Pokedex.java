package service;

import models.Pokemon;

public class Pokedex {
    private Database_Manager database_manager;

    public Pokedex(Database_Manager database_manager) {
        this.database_manager = database_manager;
    }
}

public void addPokemon(Pokemon pokemon) {}

public void removePokemon(Pokemon pokemon){}

public void updatePokemon(Pokemon pokemon){}

public List<Pokemon> fetchAllPokemon(){
    return List.of();
}

public Pokemon fetchPokemonByNumber(int number){}

public Pokemon fetchPokemonByName(String name){}


