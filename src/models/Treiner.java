package models;

import java.util.ArrayList;
import java.util.List;

public class Treiner {
    private final String name;
    private ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

    public Treiner(String name) {
        this.name = name;
    }

    public void getInfo(){
        System.out.println("Name: " + name);
        System.out.println("Pokemons: " + pokemons);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void showPokemons() {
        System.out.println("Treinador: " + this.name);
        for (Pokemon pokemon : this.pokemons) {
            String print = "Número: " + pokemon.getNumber() + " | Name:" + pokemon.getName() + " | Tipo: " + pokemon.getType().getName();
            System.out.println(print);
        }
    }

    public void addPokemon(Pokemon pokemon) {
        if (this.pokemons.size() <= 5) {
            this.pokemons.add(pokemon);
            System.out.println("Pokemon adicionado!");
        } else {
            System.out.println("Sua equipe já está cheia, remova algum pokemon antes de adicionar outro.");
            System.out.println(this.pokemons.size());
        }
    }

    public void removePokemon(String pokemonName) {
       boolean remove = pokemons.removeIf(pokemon -> pokemon.getName().equalsIgnoreCase(pokemonName));
       if(remove) {
           System.out.println("Pokemon removido!");
       }
       else {
           System.out.println("Pokemon não encontrado.");
       }
    }
}
