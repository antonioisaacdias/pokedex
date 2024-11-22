package models;

import java.util.List;

public class Treiner {
    private String name;
    private List<Pokemon> pokemons;

    public void getInfo(){
        System.out.println("Name: " + name);
        System.out.println("Pokemons: " + pokemons);
    }
}
