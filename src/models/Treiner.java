package models;

import java.util.List;

public class Treiner {
    private String name;
    private List<Pokemon> pokemons;

    public Treiner(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
    }

    public void getInfo(){
        System.out.println("Name: " + name);
        System.out.println("Pokemons: " + pokemons);
    }
}
